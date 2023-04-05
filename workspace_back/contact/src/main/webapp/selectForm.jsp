<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import java.util.List; %>
<%@ page import contactDTO.ContactDTO; %>
<%@ page import contactDAO.ContactDAO; %>
<%@ page import commons.MyDataSource; %>
<html>
    <head>
        <link href='https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css' rel='stylesheet'>
        <script src='https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js'></script>
        <script src="https://cdn.jsdelivr.net/npm/jquery/dist/jquery.min.js"></script>
        <style>
            .toCenter {
                text-align: center;
                border-radius: 10px;
                background-color: lightgray;
            }

            .toCenter:hover {
                cursor: pointer;
            }

            .disappear {
                display: none;
            }

            .margin-top-1 {
                margin-top: 10px;
            }
        </style>
    </head>
    <body>
        <div class='container'>
            <div class='row'>
                <div class='col-12 d-flex justify-content-center'>
                    <table class='table table-striped'>
                        <tr>
                            <th scope='col'>#</th>
                            <th scope='col'>이름</th>
                            <th scope='col'>연락처</th>
                            <th scope='col'>생일</th>
                        </tr>
                        <%! ContactDAO contactDAO = new ContactDAO(MyDataSource.getInstance("/Users/luke/Documents/GitHub/test/workspace_back/contact/src/main/resources/DB_properties.properties")); %>
                        <%! List<ContactDTO> contactList = contactDAO.selectAll(); %>
                        <% for(int i = 0; i < contactList.length(); i++) { %>

                        <% } %>
                        <tr>
                            <th scope='row'><%%></th>
                            <td>장길웅</td>
                            <td>01029203659</td>
                            <td>1995-11-15</td>
                        </tr>
                        <tr>
                            <th scope='row'>7</th>
                            <td>고준수</td>
                            <td>01022935832</td>
                            <td>1995-02-18</td>
                        </tr>
                        <tr>
                            <th scope='row'>9</th>
                            <td>박병구</td>
                            <td>01095883249</td>
                            <td>1993-12-03</td>
                        </tr>
                        <tr>
                            <th scope='row'>10</th>
                            <td>주경호</td>
                            <td>01046112093</td>
                            <td>1997-04-02</td>
                        </tr>
                    </table>
                </div>
                <div class='col-12'>
                    <p class='toCenter'>삭제</p>
                    <form class='disappear' action='DeleteServlet' method='post'>
                        <label for='deleteId' class='form-label'>번호</label>
                        <input name='deleteId' type='text' class='form-control' id='deleteId' placeholder='삭제할 연락처의 번호를 입력하세요.'>
                        <button class='btn btn-outline-success margin-top-1'>삭제할래</button>
                    </form>
                </div>
                <div class='col-12'>
                    <p class='toCenter'>수정</p>
                    <form class='disappear' action='UpdateServlet' method='post'>
                        <label for='updateId' class='form-label'>번호</label>
                        <input name='updateId' type='text' class='form-control' id='updateId' placeholder='수정할 연락처의 번호를 입력하세요.'>
                        <label for='updateName' class='form-label'>이름</label>
                        <input name='updateName' type='text' class='form-control' id='updateName' placeholder='이름을 입력하세요.'>
                        <label for='updateContact' class='form-label'>연락처</label>
                        <input name='updateContact' type='text' class='form-control' id='updateContact' placeholder='연락처를 입력하세요.'>
                        <label for='updateBirthday' class='form-label'>생일</label>
                        <input name='updateBirthday' type='date' class='form-control' id='updateBirthday' placeholder='생일을 입력하세요.'>
                        <button class='btn btn-outline-success margin-top-1'>수정할래</button>
                    </form>
                </div>
                <div class='col-12'>
                    <button id='returnButton' class='btn btn-outline-primary'>돌아갈래</button>
                </div>
            </div>
        </div>
        <script>
            document.querySelector('#returnButton').addEventListener('click', ()=>{
                location.href = 'index.html';
            }
            );
            $('.toCenter').on('click', function() {
                $(this).siblings('form').toggleClass('disappear');
            })
        </script>
    </body>
</html>
