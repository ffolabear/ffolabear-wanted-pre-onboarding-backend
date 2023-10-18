# 구현과정

### 1. 요구사항 분석

**필수 구현기능**

- 체용공고 등록 (회사)
- 체용공고 수정 (회사)
- 체용공고 삭제 (회사)
- 체용공고 조회 (회사)

**선택 구현기능**

- 체용공고 검색 (회사)
- 채용공고 상세 페이지 조회 (지원자)
- 채용공고 지원 (지원자)

<br>

### 2. 프로젝트 환경 설정

- 프로젝트 및 깃허브 레포지토리 생성
    - `Java 17`, `SpringBoot 3.1.4` 사용
- 프로젝트와 DB 연결

<br>

### 3. 뼈대 클래스 및 메소드 작성

- 회사의 요청과 응답을 다루는 `RecruitmentController` 와 `RecruitmentService` 클래스 생성

  #### `RecruitmentController` 메소드
    - 체용공고 등록 : `postRecruitment()`
    - 체용공고 수정 : `putRecruitment()`
    - 체용공고 삭제 : `deleteRecruitment()`
    - 체용공고 조회 : `getRecruitment()`
    - 체용공고 검색 : `getSearchedRecruitment()`

- 지원자의 요청과 응답을 다루는 `ApplicantController` 와 `ApplicantService` 클래스 생성

  #### `ApplicantController` 메소드
    - 채용 상세 페이지 조회 : `getRecruitmentDetail()`
    - 채용공고에 지원 : `postApplyingRecruitment()`

> - 파라미터는 생략하고 작성하였음
> - 메소드의 접두사는 http 요청에 맞게 네이밍


<br>
<br>