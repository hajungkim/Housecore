package com.ssafy.happyhouse.util;

import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Scanner;

public class CreateFormTableToDto {
	private String packageName;
	private StringBuilder sb = new StringBuilder();
	private static final String TAB = "    ";
	private static final String OUT_DIR = "./result";
	
	public static void main(String[] args) throws Exception {
		new CreateFormTableToDto().execute();
	}
	
	private void execute() throws Exception {
			Scanner sc = new Scanner(System.in);
			while (true) {
				System.out.print("Dto를 생성할 테이블명 : ");
				String tableName = sc.nextLine();  
				
				System.out.print("패키지명 : ");
				packageName = sc.nextLine();  
				
				makeFileTemplate(tableName);
				
				
				System.out.print("계속 진행하려면 ENTER(종료 : exit) : ");
				String isContinue = sc.nextLine(); 
				if ("exit".equals(isContinue)) break;
			}
			sc.close();
	}
	
	private void makeFileTemplate(String tableName) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			
			String sql = "select * from " + tableName;
			pstmt = con.prepareStatement(sql);
			sb.delete(0, sb.length());

			ResultSet rs = pstmt.executeQuery();
			ResultSetMetaData rsMeta = rs.getMetaData();
			
			tableName = tableName.replace("TB_", "")
					             .replace("tb_", "")
								 .replace("t_", "")
								 .replace("T_", "");

			String className = getInitCap(makeFieldName(tableName)) + "Dto";
			
			sb.append("public class " + className + " {\n");
			
			makeField(rsMeta);  // 필드 생성
			
			makeMethod(rsMeta); // set, get 메서드 생성

			sb.append("}");
			
			// class 클래스 생성
			makeClassFile(className, sb);
			
			// 버퍼 내용 삭제
			sb.delete(0, sb.length());
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(pstmt, con);
		}
	}
	
	private String getInitCap(String name){
		String result = name.substring(0,1).toUpperCase() + name.substring(1,name.length());
		return result;
	}
	
	private String getUpperName(String name){
		return name.substring(0,1).toUpperCase() + name.substring(1,name.length()).toLowerCase();
	}
	
	private String getLowerName(String name){
		return name.substring(0,1).toLowerCase() + name.substring(1,name.length()).toLowerCase();
	}
	
	private String makeDataTypeName(String colTypeName){
		if (colTypeName.equalsIgnoreCase("VARCHAR") ||
				colTypeName.equalsIgnoreCase("CHAR")) {
			return "String";
		} 
		if (colTypeName.equalsIgnoreCase("NUMBER")) {
			return "int";
		} 
		if (colTypeName.equalsIgnoreCase("DATE")) {
			return "Date";
		} 
		if (colTypeName.equalsIgnoreCase("TIMESTAMP")) {
			return "Timestamp";
		}
		return "String";
	}
	
	private void makeField(ResultSetMetaData rsMeta) throws Exception {
		for (int i = 1; i <= rsMeta.getColumnCount(); i++) {
			sb.append("    private ");
			// 데이터 타입 선언
			String dataType = makeDataTypeName(rsMeta.getColumnTypeName(i));
			if (dataType.equalsIgnoreCase("Date")) {
				sb.insert(0, "import java.util.Date;\n");
			} else if (dataType.equalsIgnoreCase("Timestamp")) {
				sb.insert(0, "import java.sql.Timestamp;\n");
			}
			sb.append(makeDataTypeName(rsMeta.getColumnTypeName(i)) + " ");
			
			// 필드명 선언
			sb.append(makeFieldName(rsMeta.getColumnName(i)) + ";\n");
		}
	}
	
	private String makeFieldName(String colName){
		String resultName = "";
		String[] colNameArr = colName.split("_");
		for(int i = 0; i < colNameArr.length; i++) {
			if (i == 0) {
				resultName = getLowerName(colNameArr[i]);
				continue;
			}
			resultName += getUpperName(colNameArr[i]);
		}
		return resultName;
	}

	private void makeMethod(ResultSetMetaData rsMeta) throws Exception {
		sb.append("\n");
		for (int i = 1; i <= rsMeta.getColumnCount(); i++) {
			String colName = rsMeta.getColumnName(i);
			String colType = rsMeta.getColumnTypeName(i);
			sb.append("\n");
			makeSetMethod(colName, colType);
			sb.append("\n");
			makeGetMethod(colName, colType);
		}
	}
	
	private void makeSetMethod(String colName, String colType) {
		String fieldName = makeFieldName(colName);
		sb.append(TAB + "public void set" + getInitCap(fieldName));
		sb.append("(" + makeDataTypeName(colType) + " " + fieldName + ")");
		sb.append(" { \n");
		sb.append(TAB + TAB + "this." + fieldName + " = " + fieldName + ";\n");
		sb.append(TAB + "}\n");
	}
	
	private void makeGetMethod(String colName, String colType) {
		String fieldName = makeFieldName(colName);
		sb.append(TAB + "public " + makeDataTypeName(colType) + " get" + getInitCap(fieldName) + "()");
		sb.append(" { \n");
		sb.append(TAB + TAB + "return " + makeFieldName(colName) + ";\n");
		sb.append(TAB + "}\n");
	}
	
	private String getOutputDir() {
		String path = CreateFormTableToDto.class.getResource(".").getPath();
		path = path.replace("\\", "/");
		path = path.substring(0, path.indexOf("/build"));
		return path +"/src/" + packageName.replace(".", "/");
	}
	
	public void makeClassFile (String className, StringBuilder sb) throws Exception {
		File f = new File(getOutputDir());
		
		if (!f.exists()) {
			f.mkdirs();
		}
		File dest = new File(f, className + ".java");
		FileWriter fw = new FileWriter(dest);
		fw.write("package " + packageName + ";\n");
		fw.write(sb.toString());
		fw.close();
	}
}

