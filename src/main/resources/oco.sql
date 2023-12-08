CREATE DATABASE oco;							
USE oco;							
								
							
CREATE TABLE users (							
user_idx INT AUTO_INCREMENT PRIMARY KEY,							
user_id varchar(300) unique,							
user_name VARCHAR(100),							
user_password VARCHAR(100),							
user_gender ENUM('M', 'W'),							
zip_code VARCHAR(20),							
address VARCHAR(255),							
address_detail VARCHAR(255),							
additional_info VARCHAR(100),							
user_hobby VARCHAR(100),							
user_phone_number VARCHAR(20),							
user_email VARCHAR(100),							
index(user_id)							
);		



CREATE TABLE business_users (							
business_idx int AUTO_INCREMENT PRIMARY KEY,							
business_id varchar(300),							
business_password VARCHAR(100) NOT NULL,							
business_name VARCHAR(100) NOT NULL,							
business_number VARCHAR(20) NOT NULL,							
business_zip_code VARCHAR(20),							
business_address VARCHAR(255),							
business_address_detail VARCHAR(255),							
business_additional_info VARCHAR(100),							
business_phone_number VARCHAR(20),							
business_email VARCHAR(100) NOT NULL,							
business_category VARCHAR(100),							
business_store_name varchar(200),							
	FOREIGN KEY (business_id) REFERENCES users(user_id)						
);	



CREATE TABLE kakao_users (							
kakao_idx VARCHAR(100) PRIMARY KEY,							
kakao_name VARCHAR(100)							
);



CREATE TABLE business_info (							
business_info_idx int primary key auto_increment,							
visit_count INT,							
use_time VARCHAR(100),							
content TEXT,							
overall_grade DECIMAL(3, 2), -- 평점							
grade_count INT, -- 평가횟수							
amenities TEXT, -- 편의시설							
business_id varchar(300) unique							
);		



create table schedule(							
schedule_num bigint auto_increment primary key,							
schedule_date varchar(500),							
store_name varchar(300),							
addr varchar(300),							
memo text,
coords text,							
user_id varchar(300)							
);




CREATE TABLE user_requests (							
request_num INT AUTO_INCREMENT PRIMARY KEY,							
category varchar(300),							
address VARCHAR(255),							
request_type VARCHAR(100),							
reg_date varchar(500),							
personnel INT,							
fuel VARCHAR(20),							
cost varchar(200),  -- money를 코스트로 수정							
amenities TEXT,							
memo TEXT,							
user_id varchar(300),							
business_id text							
);	




CREATE TABLE boards (							
board_num BIGINT AUTO_INCREMENT PRIMARY KEY,							
board_title VARCHAR(255),							
board_contents TEXT,							
reg_date DATETIME  default CURRENT_TIMESTAMP,							
update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,							
read_count INT default 0,							
user_id varchar(300),							
reply_count INT,							
category varchar(500),							
topic varchar(500)						
);	



CREATE TABLE Creplies (							
board_num int,							
reply_num BIGINT AUTO_INCREMENT PRIMARY KEY,							
user_id varchar(300),														
reply_contents VARCHAR(1000),							
reg_date DATETIME  default CURRENT_TIMESTAMP,							
update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP							
);	



CREATE TABLE Cfiles (							
system_name VARCHAR(255),							
org_name VARCHAR(255),							
board_num BIGINT							
);




CREATE TABLE replies (							
board_num int,							
reply_num BIGINT AUTO_INCREMENT PRIMARY KEY,							
user_id varchar(300),							
grade double,							
reply_contents VARCHAR(1000),							
reg_date DATETIME  default CURRENT_TIMESTAMP,							
update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP							
);	



CREATE TABLE files (							
system_name VARCHAR(255),							
org_name VARCHAR(255),							
board_num BIGINT							
);



CREATE TABLE profile (   
system_name VARCHAR(255),   
org VARCHAR(255),   
board_num BIGINT
);						