select * from tabs;

create table Board (
    
    seq number primary key,
    subject varchar2(500) not null,
    content varchar2(2000) not null,
    memberid varchar2(50) not null references Member(memberid),
    regdate date default sysdate not null
); 

create sequence seqBoard;

insert into Board(seqBoard.nextVal, '게시판입니다.','내용','dog',default);

commit;

select seq, subject, memberid, regdate from board order by seq desc;


