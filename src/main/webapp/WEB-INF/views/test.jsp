<nav aria-label="...">
    <ul class="pagination justify-content-center mt-4">
      <li class="page-item <c:if test="${not pr.prev}">disabled</c:if>">
        <a class="page-link" href="#1" 
        <c:if test="${pr.prev}">onclick="goPage(${pr.beginPage - 1});"</c:if> aria-label="Previous"> <span aria-hidden="true">«</span>
        </a>
      </li>
          <c:forEach var="i" begin="${pr.beginPage}" end="${pr.endPage}">
              <c:if test="${i != pr.pageNo}">
                  <li class="page-item"><a class="page-link" href="${root}/aptDeal?act=searchbylist&dongcode=${dongcode}&pageNo=${i}">${i}</a></li>
              </c:if>
              <c:if test="${i == pr.pageNo}">
                  <li class="page-item active">
                      <span class="page-link">
                      ${i}
                      <span class="sr-only">(${i})</span>
                    </span>
                </li>
              </c:if>
          </c:forEach>

      <li class="page-item <c:if test="${not pr.next}">disabled</c:if>">
        <a class="page-link" href="#" <c:if test="${pr.next}">onclick="goPage(${pr.endPage + 1});"</c:if>><span aria-hidden="true">»</span></a>
      </li>
    </ul>
  </nav>