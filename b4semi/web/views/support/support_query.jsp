<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp"%>
<%@ page import="com.b4.model.vo.QueryBoard, com.b4.model.vo.QueryComment" %>
<%@ page import="com.b4.model.vo.Member" %>
<%@ page import="java.util.*" %>
<%@ page import="static common.DateFormatTemplate.getTillMin" %>
<%@ page import="static common.DateFormatTemplate.getTillDate" %>

<%
	Member lm = (Member)request.getAttribute("loginMember");
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
            font-size: 14px;
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
            text-shadow: 1px 1px 5px rgba(0, 0, 0, 0.3);
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
            height: inherit;
            border: none;
            background-color: transparent;
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
            font-size: 14px;
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
        .query-board-header > div:nth-of-type(4){flex: 3 1 0;}

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
        .query-board-cols > div:nth-of-type(4){flex: 3 1 0; color: gray; font-size: 11px;padding-top: 2px;}
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

        .query-comment-unit
        {
            position: relative;
            height: 150px;
            margin-top: 10px;
            margin-bottom: 20px;
            padding: 15px 0 0 20px;
            border-radius: 5px;
            box-sizing: border-box;
        }

        .query-comment-unit[comment-writer="customer"]
        {
            background-color: rgb(247, 247, 247);

        }

        .query-comment-unit[comment-writer="admin"]
        {
            background-color: rgba(79, 142, 158, 0.438);
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
            position: absolute;
            height: inherit;
            top: 0;
            left: 0;
            width: 100%;
        }

        .written-comment-textarea
        {
            box-sizing: border-box;
            padding-top: 50px;
            padding-left: 18px;
            transform-style: preserve-3d;

        }

        .written-comment-textarea:read-write
        {
            box-shadow: 0 1px 15px 1px rgba(0, 0, 0, 0.6);
            border-radius: 5px;
        }
        
        .query-comment-form
        {
            position: relative;
            margin-top: 10px;
            margin-bottom: 10px;
            margin-right: 20px;
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
            border-radius: 5px;
            height: 60px;
            transition: 200ms ease-in;
        }

        .query-comment-confirm{display: none;}
        .query-comment-cancel{display: none;}


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


        .query-write
        {
            padding: 0 10px;
            height: 35px;
            align-self: flex-end;
            
        }


        .cmt-confirm-anim
        {
            animation: modSuccess 1s ease;
        }

        .cmt-mod-anim
        {
            animation: modClicked 150ms ease;
        }


        @keyframes modSuccess
        {
            100%{
                transform: rotateY(-180deg);
            }
        }

        @keyframes modClicked
        {
            50%{
                transform: rotateZ(3deg);
            }
            100%{
                transform: rotateZ(0deg);
            }
        }
    </style>
    <section>
        <div class="support-wrapper">
            <div class="support-side">
                <div class="support-nav-title">
                    <p>고객센터</p>
                </div>
                <div class="support-nav">
                    <div><a href="<%=request.getContextPath()%>/noticeList">공지사항<img src="<%=request.getContextPath() %>/images/arrow_right_black.png"></a>
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
                        <%if(list.size() != 0)
                        {
                        	for(QueryBoard qb : list)
                        	{%>
                        <div class="query-board-cols">
                            <div><%=qb.getQuerySeq() %></div>
                            <div><%=qb.getQueryTitle() %> [<%=qb.getList().size() %>]</div>
                            <div><%=qb.getMemberId() %></div>
                            <div><%=getTillMin(qb.getQueryDate()) %></div>
                        </div>
                        <div class="query-board-view-unit">
                            <div class="query-board-content">
                            	<%if(qb.getRenamedFile() != null) 
                            	{%>
                            	<img src="<%=request.getContextPath() %>/upload/queryBoard/<%=qb.getRenamedFile()%>">
                            	<% }%>
                            	<%=qb.getQueryContents() %>
                                <div data-query-seq="<%=qb.getQuerySeq() %>" class="query-board-btn-set">
                                    <button class="query-modify">수정</button>
                                    <button class="query-delete">삭제</button>
                                </div>
                            </div>
                            <%if(qb.getList().size() != 0)
                            {
                            	for(QueryComment qc : qb.getList())
                            	{%>
                            <div comment-writer="<%="admin".equals(qc.getMemberId())?"admin":"customer" %>" class="query-comment-unit">
                                <div class="query-comment-header">
                                    <div class="query-comment-id"><b><%=qc.getMemberId() %></b></div>
                                    <div class="query-comment-date"><%=getTillMin(qc.getCommentDate()) %></div>
                                </div>
                                <div class="query-comment-content">
                                    <textarea name="commentText" class="written-comment-textarea" readonly="readonly"><%=qc.getCommentText() %></textarea>
                                </div>
                                
                                <%if(qc.getMemberId().equals(lm.getMemberId())) { %>
                                <div data-comment-seq="<%=qc.getCommentSeq() %>" class="query-comment-btn-set">
                                    <button class="query-comment-cancel">취소</button>
                                    <button class="query-comment-confirm">수정완료</button>
                                    <button class="query-comment-modify">수정</button>
                                    <button class="query-comment-delete">삭제</button>
                                </div>
                                <%} %>
                            </div>
                            <% }
                            }%>
                            <div class="query-comment-form">
                                <textarea name="commentText" id="comment-form-area" placeholder="댓글을 입력하세요."></textarea>
                                <button data-query-seq="<%=qb.getQuerySeq() %>" class="query-comment-write">전송</button>
                            </div>
                        </div>
                    <%	}
                    }%>
                    </div>
                    <button class="query-write" onclick="location.href='<%=request.getContextPath()%>/queryForm';">글쓰기</button>
					<%=pageBar %>
                </div>
            </div>
        </div>
    </section>
    <script>
    
    //1:1 문의 게시판 토글
    const queryCols = $('.query-board-cols');
    const queryViews = $('.query-board-view-unit');
    $(() => {
        queryCols.on('click', (e) => {
            if($(e.currentTarget).next(queryViews).is(':visible')) { queryViews.hide(); return; }
            else {queryViews.hide();}
            $(e.currentTarget).next(queryViews).toggle();
        });
    });

    const queryModify = $('.query-modify');
    const queryDelete = $('.query-delete');
    const queryWrite = $('.query-write');
    const queryCmtMod = $('.query-comment-modify');
    const queryCmtDel = $('.query-comment-delete');
    const queryCmtWrite = $('.query-comment-write');
    const queryConfirm = $('.query-confirm');
    const queryCmtCancel = $('.query-comment-cancel');
    const commentFormArea = $('#comment-form-area');

    
    //커멘트 수정버튼 콜백 함수
    const commentModFunc = (e) => {

        const targetTextarea = $(e.target).parent().prev().children();
        const targetModBtn = $(e.target);
        const confirmBtn = $(e.target).prev();
        const cancelBtn = $(e.target).prev().prev();
        const deleteBtn = $(e.target).next();
    
        const targetCommentUnit = $(e.target).parent().parent();
        targetCommentUnit.addClass('.cmt-mod-anim');
        setTimeout(() => {targetCommentUnit.removeClass('.cmt-mod-anim')}, 1000);

        targetModBtn.hide();
        deleteBtn.hide();
        confirmBtn.fadeToggle(500);
        cancelBtn.fadeToggle(500);
        targetTextarea.removeAttr('readonly');
        targetTextarea.focus();
        
        let targetTextSave = targetTextarea.text();

        //커멘트 텍스트창 토글 백 함수 정의
        const toggleBack = () => {
            targetTextarea.attr('readonly', 'readonly');
            confirmBtn.hide();
            cancelBtn.hide();
            deleteBtn.fadeToggle(500);
            targetModBtn.fadeToggle(500);
            cancelBtn.off('click');
        }

        //커멘트 수정 취소버튼 이벤트 바인드
        cancelBtn.on('click', e => {
            targetTextarea.val(targetTextSave);
            toggleBack();
        });

        //수정확인버튼 이벤트 바인드
        confirmBtn.on('click', e => {

            let flag = confirm('정말로 수정하시겠습니까?');
            if(flag)
            {
                $.ajax({
                    url: '<%=request.getContextPath()%>/queryCommentModify',
                    type: 'post',
                    data: {'commentSeq': $(e.target).parent().data('commentSeq'), 'commentText': targetTextarea.val()},
                    dataType: 'text',
                    success: data => {
                        alert('수정이 완료되었습니다.');
                        toggleBack();
                    }
                });
            }
        });
    }
    
    //커멘트 수정버튼 이벤트 바인드
    $(() => {
        queryCmtMod.on('click', commentModFunc);
    });
    
    //커멘트 삭제버튼 이벤트 바인드
    $(() => {
        queryCmtDel.on('click', queryCmtDelFunc);

        //1:1문의 삭제버튼 이벤트 바인드
        queryDelete.on('click', e => {
            let flag = confirm('정말로 삭제하시겠습니까?');
            if(flag)
            {
                location.href='<%=request.getContextPath()%>/queryDelete?querySeq='+$(e.target).parent().data('querySeq');
            }
        });
    });
    
    //커멘트 삭제버튼 이벤트 함수
    const queryCmtDelFunc = (e) => {
        let flag = confirm('정말로 삭제하시겠습니까?');
        if(flag)
        {
            $.ajax({
                url: '<%=request.getContextPath()%>/queryCommentDelete?commentSeq='+$(e.target).parent().data('commentSeq'),
                type: 'get',
                dataType: 'text',
                success: data => {
                	if(data = 1)
                    {
                		$(e.target).parent().parent().fadeOut(400);
                		setTimeout(() => {$(e.target).parent().parent().remove();}, 400);
                		
                    }
                	else
                	{
                		alert('커멘트 삭제에 실패하였습니다.');
                	}
                }
            });
        }
    }

    //커멘트 작성버튼 이벤트 바인드
    $(() => {
        queryCmtWrite.on('click', e => {
            textToSend = $(e.target).prev().val();
            if(textToSend.trim().length == 0)
           	{alert('댓글은 1자 이상 입력 가능합니다.'); return;}
            
           	$.ajax({
                url: '<%=request.getContextPath()%>/queryCommentForm',
                type: 'post',
                data: {'commentText': textToSend, 'memberSeq': <%=lm.getMemberSeq()%>, 'boardSeq': $(e.target).data('querySeq')},
                dataType: 'json',
                success: data => {
                	if(data.result == 1)
                	{
                		const commentToAdd =
                			'<div comment-writer="<%="admin".equals(lm.getMemberId())?"admin":"customer" %>" class="query-comment-unit" style="display:none">'
                			+'<div class="query-comment-header">'
                				+'<div class="query-comment-id"><b><%=lm.getMemberId() %></b></div>'
                				+'<div class="query-comment-date">'+data.commentDate+'</div>'
                			+'</div>'
                			+'<div class="query-comment-content">'
	                			+'<textarea name="commentText" class="written-comment-textarea" readonly="readonly">'+data.commentText+'</textarea>'
                			+'</div>'
                			+'<div data-comment-seq="'+data.currval+'" class="query-comment-btn-set">'
	                			+'<button class="query-comment-cancel">취소</button>'
	                			+'<button class="query-comment-confirm">수정완료</button>'
	                			+'<button class="query-comment-modify">수정</button>'
	                			+'<button class="query-comment-delete">삭제</button>'
                			+'</div>'
                			+'</div>';
                			commentFormArea.parent().before(commentToAdd);
                			commentFormArea.parent().prev().fadeIn(400);
                			queryCmtMod.off('click');
                			$('.query-comment-modify').on('click', commentModFunc);
                			
                	}
                	else{
                		alert('댓글 등록에 실패하였습니다.');
                	}
                }
            });
        });
    });

    //1:1 문의 수정버튼 이벤트 바인드
    $(() => {
        queryModify.on('click', e => {
            console.log($(e.target).parent().data('querySeq'))
            location.href='<%=request.getContextPath()%>/queryModify?querySeq='+$(e.target).parent().data('querySeq');
        });
    });
    </script>
<%@ include file="/views/common/footer.jsp" %>