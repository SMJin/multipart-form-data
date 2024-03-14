# multipart-form-data
#### HTTP multipart/form-data
#### [Class StandardMultipartHttpServletRequest.StandardMultipartFile](https://docs.spring.io/spring-framework/docs/4.3.10.RELEASE_to_4.3.11.RELEASE/Spring%20Framework%204.3.11.RELEASE/org/springframework/web/multipart/support/StandardMultipartHttpServletRequest.StandardMultipartFile.html)

#### HttpServletRequest Interface 내부의 메소드
- Collection<Part> getParts() throws IOException, ServletException;
- Part getPart(String var1) throws IOException, ServletException;
- 여러 Parts(파일들)을 받아올 때는 Collections를 이용해서 여러 Part를 받아오고,
- 단일 Part(파일)일 때는 Part만 받아오면 된다.

#### spring.servlet.multipart.enabled=false
- 위와 같이 application.properties 에 설정하면 multipart 를 받을 수 없게 된다.

#### javax.servlet.http Interface [Part](https://docs.oracle.com/javaee%2F7%2Fapi%2F%2F/javax/servlet/http/Part.html)
- part.getSubmittedFileName() : 클라이언트가 전달한 파일명 return String
- part.getInputStream(): Part의 전송 데이터를 읽을 수 있다. return InputStream
- part.write(String fileName): Part를 통해 전송된 데이터를 저장할 수 있다. return void

#### 고려해야 할 점
- DB에 저장할 때 파일 명으로 파일을 찾을 수 있게 해야한다. (하지만 사용자가 등록할 땐 중복 이름 가능)
- 다중 업로드/다운로드가 가능해야 한다.

#### 참고
- input 태그에 multiple="multiple"을 넘겨주면 다중 파일을 넘길 수 있다.
- 보통 파일 자체를 DB에 저장하지는 않는다. 경로만 저장해놓는다.
