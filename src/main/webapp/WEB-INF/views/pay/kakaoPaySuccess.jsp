<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 
카카오페이 결제가 정상적으로 완료되었습니다.
 
결제일시:     [[${info.approved_at}]]<br/>
예약일:
이메일:
카카오ID:
주문번호:    [[${info.partner_order_id}]]<br/>
예약상품명:    [[${info.item_name}]]<br/>
상품수량:    [[${info.quantity}]]<br/>
인원 :
연락처:
결제자명:
결제금액:    [[${info.amount.total}]]<br/>
결제방법:    [[${info.payment_method_type}]]<br/>
기타사항:
 
 
 
<h2>[[쌍용크레파스를 이용해주셔서 감사합니다]]</h2>
 
</body>
</html>