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
	private int cartNo; // ��ٱ��� ��ȣ
	private int userNo; // ����� ��ȣ
	private int productId; // ��ǰ ��ȣ
	private String productName; // ��ǰ �̸�
	private int productPrice; // ��ǰ �ܰ�
	private int cartStock; // ���� ����
	private int money; // ��ǰ ����
	
}
