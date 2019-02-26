<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp"%>
<%@ page import="com.b4.model.vo.QueryBoard, com.b4.model.vo.QueryComment" %>
<%@ page import="java.util.*" %>
<%@ page import="static common.DateFormatTemplate.getTillMin" %>
<%
	List<QueryBoard> list = (List<QueryBoard>)request.getAttribute("list");
	int cPage = (int)request.getAttribute("cPage");
	String pageBar = (String)request.getAttribute("pageBar");
%>

    <style>
        .support-wrapper
        {
            display: flex;
            font-family: 'Noto Sans KR';
            width: 1024px;
            margin-top: 100px;
            font-size: 12px;
        }

        .support-wrapper > div:first-of-type
        {
            flex: 2 1 0;
        }

        .support-wrapper > div:last-of-type
        {
            flex: 7 1 0;
        }

        .support-nav-title > p
        {
            margin: 20px 0;
            font-size: 30px;
        }
        
        .support-nav
        {
            display: flex;
            flex-flow: column nowrap;
            position: relative;
        }

        .support-nav > div
        {
            height: 50px;
            border: 1px solid #ccc;
            border-bottom: none;
            display: flex;
            align-items: center;
            justify-content: space-between;
            box-sizing: border-box;
            padding: 0 30px;
            font-size: 15px;

            cursor: pointer;
        }

        .support-nav > div:hover
        {
            background-color: rgb(248, 248, 248);
        }

        .support-nav a
        {
            text-decoration: none;
            color: black;
            width: 100%;
            height: 100%;
            display: flex;
            align-items: center;
        }

        .support-nav img
        {
            width: 25px;
            height: 25px;
            position: absolute;
            right: 0;
        }

        .support-nav > div:last-of-type
        {
            border-bottom: 1px solid #ccc;
        }

        .current-tab
        {
            background-color: rgb(248, 248, 248);
        }

        .support-content
        {
            display: flex;
            flex-flow: column nowrap;
            justify-content: center;
            margin-left: 30px;
        }


        .query-wrapper
        {
            font-family: 'Noto Sans KR';
            display: flex;
            flex-flow: column nowrap;
            width: 100%;
            font-size: 14px;
        }

        .query-wrapper button
        {
            font-family: 'Noto Sans KR';
/*             text-shadow: 1px 1px 5px rgba(0, 0, 0, 0.1); */
            background-color: transparent;
            border: none;
            font-weight: bolder;
            opacity: 0.5;
            font-size: 15px;

            cursor: pointer;
        }

        .query-wrapper button:hover{opacity: 0.8;}
        .query-wrapper button:focus{outline: none;}
        .query-wrapper textarea{
            width: 100%;
            resize: none;
            font-family: 'Noto Sans KR';
            min-height: 70px;
            max-height: 70px;
            border: none;
            background-color: transparent;
            font-size: 15px;
        }

        .query-wrapper textarea:focus
        {
            outline: none;
        }

        .query-wrapper-header
        {
            font-size: 25px;
            padding: 25px 0;
        }

        .query-board
        {
            border-top: 2px solid rgb(38, 85, 139);
            border-bottom: 1px solid #ccc;
            display: flex;
            flex-flow: column nowrap;
        }

        .query-board-header
        {
            display: flex;
            padding: 15px 0;
        }


        .query-board-header > div
        {
            display: flex;
            align-items: center;
            justify-content: center;
        }
        .query-board-header > div:nth-of-type(1){flex: 2 1 0;}
        .query-board-header > div:nth-of-type(2){flex: 15 1 0;}
        .query-board-header > div:nth-of-type(3){flex: 2 1 0;}
        .query-board-header > div:nth-of-type(4){flex: 4 1 0;}

        .query-board-cols
        {
            display: flex;
            padding: 15px 0;
            border-top: 1px solid #ccc;
        }

        .query-board-cols > div
        {
            display: flex;
            align-items: center;
            justify-content: center;
        }
        .query-board-cols > div:nth-of-type(1){flex: 2 1 0;}
        .query-board-cols > div:nth-of-type(2){flex: 15 1 0;}
        .query-board-cols > div:nth-of-type(3){flex: 2 1 0;}
        .query-board-cols > div:nth-of-type(4){flex: 4 1 0; font-size: 11px; color: gray;}
        .query-board-cols:last-of-type{border-bottom: 1px solid black;}

        .query-board-btn-set
        {
            position: absolute;
            top: 15px;
            right: 9px;
        }

        .query-comment-btn-set
        {
            position: absolute;
            top: 15px;
            right: 9px;
        }
        
        .comment-count
        {
        	color: rgb(62, 91, 134);
        }

        .query-board-view-unit
        {
            display: flex;
            flex-flow: column nowrap;
            border-top: 1px solid #eee;
            display: none;
        }

        .query-board-content
        {
            position: relative;
            min-height: 80px;
            padding: 20px 15px 20px 50px;
        }

        .query-comment-unit[comment-writer="customer"]
        {
            position: relative;
            margin-left: 150px;
            margin-top: 10px;
            margin-bottom: 10px;
            padding: 15px 0 0 20px;

            background-color: rgb(247, 247, 247);
            border-radius: 10px;
        }

        .query-comment-unit[comment-writer="admin"]
        {
            position: relative;
            margin-right: 150px;
            margin-top: 10px;
            margin-bottom: 10px;
            padding: 15px 0 0 20px;

            background-color: rgb(255, 249, 231);
            border-radius: 10px;
        }

        .query-comment-header
        {
            display: flex;
            align-items: center;
        }

        .query-comment-id
        {
            font-size: 14px;
        }

        .query-comment-date
        {
            font-size: 12px;
            color: gray;
            padding-left: 5px;
        }

        .query-comment-content
        {
            padding: 20px 20px 20px 0;
            padding-bottom: 20px;
            margin-left: -2px;
        }

        .query-comment-form
        {
            position: relative;
            margin-top: 10px;
            margin-right: 20px;
            margin-bottom: 10px;
            margin-left: 150px;
        }

        .query-comment-write
        {
           position: absolute;
           bottom: 13px;
           right: -10px;
        }

        .query-comment-write button
        {
            color: white;
        }

        #comment-form-area
        {
            padding: 10px 0 0 20px;
            background-color: rgb(247, 247, 247);
            border-radius: 10px;
            min-height: 30px;
            max-height: 30px;
        }

        #comment-form-area:focus
        {
            background-color: rgb(221, 221, 221);
            box-shadow: 0 1px 10px 1px rgba(0, 0, 0, 0.3);
            min-height: 100px;
            max-height: 100px;
        }

        #comment-form-area:focus + button
        {
        }

        #comment-form-area:focus + button:hover
        {

        }
        
        .form-query
        {
        	width: 100px;
        	height: 40px;
        	background-color: rgb(62, 91, 134);
        	color: white;
        	border: none;
        	align-self: flex-end;
        	border-radius: 2px;
        	margin-top: 20px;
        	transition: 200ms linear;
        	cursor: pointer;
        }
        
        .form-query:hover
        {
        	background-color: rgb(82, 111, 154);
        }
        

        .form-query:focus{outline: none;}

        .pagebar img
        {
            width: 40%;
            height: 40%;
        }

        .pagebar
        {
            display: flex;
            align-self: center;
            margin: 40px;
            font-size: 12px;
        }

        .pagebar > div
        {
            width: 33px;
            height: 33px;
            border: 1px solid rgb(220, 220, 220);
            border-left: none;
            display: flex;
            align-items: center;
            justify-content: center;
            cursor: pointer;
        }

        .pagebar > div:first-of-type
        {
            border-left: 1px solid rgb(220, 220, 220);
        }
        
    </style>
    <section>
        <div class="support-wrapper">
            <div class="support-side">
                <div class="support-nav-title">
                    <p>고객센터</p>
                </div>
                <div class="support-nav">
                    <div><a href="">공지사항<img src="<%=request.getContextPath() %>/images/arrow_right_black.png"></a>
                    </div>
                    <div class="current-tab"><a href="#">1:1문의<img src="<%=request.getContextPath() %>/images/arrow_right_black.png"></a>
                    </div>
                    <div><a href="">상품제안<img src="<%=request.getContextPath() %>/images/arrow_right_black.png"></a>
                    </div>
                </div>
            </div>
            <div class="support-content">
                <div class="query-wrapper">
                    <div class="query-wrapper-header">
                        <span>1:1 문의</span>
                    </div>
                    <div class="query-board">
                        <div class="query-board-header">
                            <div>번호</div>
                            <div>제목</div>
                            <div>작성자</div>
                            <div>작성일</div>
                        </div>
                        <%for(QueryBoard qb : list)
                        { %>
                        <div class="query-board-cols">
                            <div><%=qb.getQuerySeq() %></div>
                            <div><%=qb.getQueryTitle() %><span class="comment-count">&nbsp;[<%=qb.getList().size()%>]</span></div>
                            <div><%=qb.getMemberId() %></div>
                            <div><%=getTillMin(qb.getQueryDate()) %></div>
                        </div> 
                        <div class="query-board-view-unit">
                            <div class="query-board-content">
                            	<%=qb.getQueryContents() %>
                                <div class="query-board-btn-set">
                                    <button data-query-seq="<%=qb.getQuerySeq() %>" class="query-modify">수정</button>
                                    <button data-query-seq="<%=qb.getQuerySeq() %>" class="query-delete">삭제</button>
                                </div>
                            </div>
                            <%if(qb.getList().size() != 0) 
                              {	
                            	 for(QueryComment qc : qb.getList())
                            	 {
                            %>
                            <div comment-writer="<%="admin".equals(qc.getMemberId())?"admin":"customer"%>" class="query-comment-unit">
                                <div class="query-comment-header">
                                    <div class="query-comment-id"><b><%=qc.getMemberId() %></b></div>
                                    <div class="query-comment-date"><%=getTillMin(qc.getCommentDate())%></div>
                                </div>
                                <div class="query-comment-content">
                                    <%=qc.getCommentText() %>
                                </div>
                                <%if("admin".equals(qb.getMemberId())){ %>
                                <div class="query-comment-btn-set">
                                    <button class="query-comment-modify">수정</button>
                                    <button class="query-comment-delete">삭제</button>
                                </div>
                            	<%} %>    
                            
                            </div>
                              <%}%> 
                            <div class="query-comment-form">
                                <textarea name="commentText" id="comment-form-area"></textarea>
                                <button class="query-comment-write">작성</button>
                            </div>
                           <%}  %>
                        </div>
                    	<%} %>
                    </div>
                    <input class="form-query" type="button" value="1:1문의">
				<%=pageBar %>
            </div>
        </div>
   	</div>
    </section>
    <script>
        const queryCols = $('.query-board-cols');

        const queryViews = $('.query-board-view-unit');

        //게시판 토글 이벤트
        $(() => {
            queryCols.on('click', (e) => {
                if($(e.currentTarget).next(queryViews).is(':visible')) { queryViews.hide(); return; }
                else {queryViews.hide();}
                
                $(e.currentTarget).next(queryViews).toggle();
            });
        });
        const queryModify = $('.query-modify');
        const queryDelete = $('.query-delete');
        const queryCmtMod = $('.query-comment-modify');
        const queryCmtDel = $('.query-comment-delete');
        const queryCmtWrite = $('.query-comment-write');
        
        //게시판 버튼 클릭 이벤트
        $(() => {
        	queryModify.on('click', (e) => {
        		location.href = '<%=request.getContextPath()%>/queryModify?querySeq='+$(e.target).data('query-seq');
        	});
        	queryDelete.on('click', (e) => {
        		location.href = '<%=request.getContextPath()%>/queryDelete?querySeq='+$(e.target).data('query-seq');
        	});
        });
    </script>
<%@ include file="/views/common/footer.jsp" %>