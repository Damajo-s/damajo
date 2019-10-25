/**
 * 
 */
package com.damajo.vo;

import lombok.Getter;
import lombok.Setter;

/**
 * CREATE TABLE CART (
    cartNo NUMBER NOT NULL PRIMARY KEY,
    userNo NUMBER NOT NULL,
    pNo NUMBER NOT NULL,
    cartStock NUMBER DEFAULT 0,
    CONSTRAINT cart_userNo_fk FOREIGN KEY(userNo) REFERENCES MEMBER(no),
    CONSTRAINT cart_pNo_fk FOREIGN KEY(pNo) REFERENCES PRODUCT(no)
);

	CREATE SEQUENCE cart_seq
	START WITH 10
	INCREMENT BY 1;
 */
@Getter
@Setter
public class CartVO {
	private int cartNo; // 장바구니 번호
	private int userNo; // 사용자 번호
	private int productId; // 상품 번호
	private String productName; // 상품 이름
	private int productPrice; // 상품 단가
	private int cartStock; // 구매 수량
	private int money; // 상품 가격
	
}
