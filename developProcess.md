# 구현과정

### 1. 요구사항 분석

**필수 구현기능**

- 체용공고 등록 (회사)
- 체용공고 수정 (회사)
- 체용공고 삭제 (회사)
- 체용공고 조회 (회사)

**선택 구현기능**

- 체용공고 검색 (회사)
- 채용공고 상세 조회 (지원자)
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

### 4. 코드 구현
> repository - service - controller 순으로 구현

#### 4.1 채용공고 관련 기능 구현
  - 4.1.1 `채용공고 등록` 기능구현
  - 4.1.2 `채용공고 수정` 기능구현
  - 4.1.3 `채용공고 삭제` 기능구현

<br>

#### 4.2 지원자 관련 기능 구현
- 4.2.1 `채용공고 전체 조회` 기능구현
- 4.2.2 `채용공고 검색` 기능구현
  - `QueryDSL` 환경 추가 세팅
- 4.2.3 `채용공고 상세 조회` 기능구현
- 4.2.4 `채용공고 지원` 기능구현

<br>

### 5. 기능 테스트
> service - controller 순으로 기능 테스트 

#### 5.1 채용공고 관련 기능 테스트
- 테스트용 DB 구축 ( h2 )
- `RecruitmentService` 기능 테스트
- `RecruitmentController` 기능 테스트
- 테스트용 더미데이터 자동생성 클래스 추가

#### 5.1
- `ApplicantService` 기능 테스트
- `ApplicantController` 기능 테스트

<br>

### 6. 리팩토링
- 전체 코드 리팩토링

<br>
<br>