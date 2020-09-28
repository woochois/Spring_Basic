drop table member4;
create table member4 (
	id varchar2(20) primary key,
	email varchar2(30),
	password varchar2(30),
	name varchar2(30),
	fileName varchar2(50) default 'a.jpg',
	del char(1) default 'n',
	regdate date
);

create table memberphoto (
	num number(10) primary key,
	id varchar2(20) references member4(id),
	fileName  varchar2(50)
);
create sequence memberphoto_seq;
select * from member3;
select * from memberphoto;
drop table member5;