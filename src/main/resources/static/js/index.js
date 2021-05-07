$('.loginbt').click(function () {
    $.ajax({
        url: '../userlist.xml',
        
        type: 'GET',
        dataType: 'xml',
        success: function (response) {
            loginList(response);
        },
        error: function (xhr, status, msg) {
            console.log('오류');
        }
    });
});

var id = '';
var pw = '';
// 로그인 확인
function loginList(data) {
    let cnt = 0;
    $(data).find('item').each(function (index, item) {
        console.log(cnt);
        if ($('#loginid').val().length != 0) {
            if ($('#loginid').val() == $(this).find('id').text() && $('#loginpwd').val() == $(this)
                .find('password').text()) {
                alert('로그인 성공 !');
                id = $('#loginid').val();
                pw = $('#loginpwd').val();
                $('#toplogout').css('display', 'block');
                $('#topid').css('display', 'block').text($('#loginid').val() + '(내정보)');
                $('#toplogin').css('display', 'none');
                $('#topsignup').css('display', 'none');
                $('#toppass').css('display', 'none');
                $('.like').css('display', 'block');
                $('.admin').css('display', 'block');
                cnt--;
            }
            if (cnt == 3) {
                cnt = 0;
                alert('입력을 확인하세요.');
            }
        } else if ($('#loginid').val().length == 0) {
            aler('입력창을 확인하세요');
        }
        cnt++;
    });

};
// 로그아웃
$('#toplogout').click(function () {
    $('#toplogout').css('display', 'none');
    $('#topid').css('display', 'none').text($('#loginid').val());
    $('#toplogin').css('display', 'block');
    $('#topsignup').css('display', 'block');
    $('#toppass').css('display', 'block');
    $('.like').css('display', 'none');
    $('.admin').css('display', 'none');
});

// 회원가입버튼
$('.signUpbt').click(function () {
    $.ajax({
        url: '../userlist.xml',
        type: 'GET',
        dataType: 'xml',
        success: function (response) {
            makeList(response);
        },
        error: function (xhr, status, msg) {
            console.log('오류');
        }
    });
});

function makeList(data) {
    if ($('#usrid').val().length != 0 &&
        $('#pwd').val().length != 0 &&
        $('#name').val().length != 0 &&
        $('#cp').val().length != 0 &&
        $('#add').val().length != 0) {

        let cnt = 0;
        let MemID = $('#usrid').val();
        $(data).find('item').each(function (index, item) {
            cnt++;
            if (MemID == $(this).find('id').text()) {
                alert('중복된 ID입니다.');
                cnt--;
                console.log('중복 : ' + cnt);
            }
            if (cnt == 4) {
                cnt = 0;
                alert('회원가입을 축하합니다.');
                location.href = "index.html";
            }
        });

    } else if ($('#usrid').val().length == 0 ||
        $('#pwd').val().length == 0 ||
        $('#name').val().length == 0 ||
        $('#cp').val().length == 0 ||
        $('#add').val().length == 0) {
        alert('입력칸을 확인해주세요.');
    }
};
// 내정보 확인
$('#topid').click(function() {
    $('#div1').text($('#div1').text() + id);
    $('#div2').text($('#div2').text() + pw);
    $('#div3').text($('#div3').text() + '싸피 5기 화이팅');
    $('#div4').text($('#div4').text() + '010-0000-0000');
    $('#div5').text($('#div5').text() + '대전광역시');
})


// 회원 정보 체크
$('.searchbtn').click(function () {
    $('#div1').text($('#div1').text() + $('#usrid').val());
    $('#div2').text($('#div2').text() + $('#pwd').val());
    $('#div3').text($('#div3').text() + $('#name').val());
    $('#div4').text($('#div4').text() + $('#cp').val());
    $('#div5').text($('#div5').text() + $('#add').val());
})


// 비밀 번호 찾기
$('.findbtn').click(function () {
    console.log(1);
    $.ajax({
        url: '../userlist.xml',
        type: 'GET',
        dataType: 'xml',
        success: function (response) {
            findList(response);
        },
        error: function (xhr, status, msg) {
            console.log('오류');
        }
    });
});

function findList(data) {
    let cnt = 0;
    if ($('#findid').val().length != 0 &&
        $('#findname').val().length != 0) {
        $(data).find('item').each(function (index, item) {
            cnt++;
            console.log($('#findid').val());
            console.log($(this).find('id').text());
            if ($('#findid').val() == $(this).find('id').text()) {
                alert(`사용자의 PassWord는 ${$(this).find('password').text()} 입니다.`);
                cnt--;
                location.href = "index.html";
            }
            if (cnt == 4) {
                cnt = 0;
                alert('해당 정보가 존재하지않습니다.');
            }
        });
    } else if ($('#findid').val().length == 0 && $('#findname').val().length == 0) {
        alert('입력창을 확인하세요');
    }
}