-- spring

create table tblAddress (
    seq number primary key,
    name varchar2(30) not null,
    age number not null,
    address varchar2(100) not null,
    gender char(1) not null
);

create sequence seqAddress;

insert into tblAddress valuse (seqAddress.nextval, '홍길동', 20,'서울시', 'm');

select * from tblAddress;

select * from tblAddress where seq = 19;

select name from tblAddress;

delete from tblAddress where seq = 18;

commit;