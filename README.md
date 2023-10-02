# 원티드 프리온보딩 백엔드 인턴십 선발과제

### ⚙️ 사용기술
- Java 17 (Amazon corretto)
- SpringBoot 3.1.4
- JPA
- MySQL

## 📌 요구사항
- 아래의 데이터는 예시이며 변경될 수 있음
 
### 1. 채용공고를 등록합니다.
> 회사는 아래 데이터와 같이 채용공고를 등록합니다.

```json
{
  "회사_id": "회사 id",
  "채용포지션":"백엔드 주니어 개발자",
  "채용보상금":1000000,
  "채용내용":"원티드랩에서 백엔드 주니어 개발자를 채용합니다. 자격요건은..",
  "사용기술":"Python"
}
```

<br>

### 2. 채용공고를 수정합니다.
> 회사는 아래 데이터와 같이 채용공고를 수정합니다. (회사 id 이외 모두 수정 가능합니다.)

```json
{
  "채용포지션":"백엔드 주니어 개발자",
  "채용보상금":1500000,                                              //변경됨
  "채용내용":"원티드랩에서 백엔드 주니어 개발자를 '적극' 채용합니다. 자격요건은..", //변경됨
  "사용기술":"Python"
}

```

**or**
```json
{
  "채용포지션":"백엔드 주니어 개발자",
  "채용보상금":1000000,
  "채용내용":"원티드랩에서 백엔드 주니어 개발자를 채용합니다. 자격요건은..",
  "사용기술":"Django"                                               //변경됨
}
```

<br>

### 3. 채용공고를 삭제합니다.
> DB에서 삭제됩니다.

<br>

### 4. 채용공고 목록을 가져옵니다.
#### 4-1. 사용자는 채용공고 목록을 아래와 같이 확인할 수 있습니다.

```json
[
  {
    "채용공고_id": "채용공고 id",
    "회사명": "원티드랩",
    "국가": "한국",
    "지역": "서울",
    "채용포지션": "백엔드 주니어 개발자",
    "채용보상금": 1500000,
    "사용기술": "Python"
  },
  {
    "채용공고_id": "채용공고 id",
    "회사명": "네이버",
    "국가": "한국",
    "지역": "판교",
    "채용포지션": "Django 백엔드 개발자",
    "채용보상금": 1000000,
    "사용기술": "Django"
  }
  //...
]
```

<br>

#### 4-2. 채용공고 검색 기능 구현(선택사항 및 가산점요소).

**Example 1 : `some/url?search=원티드`**
```json
[
  {
    "채용공고_id": "채용공고 id",
    "회사명": "원티드랩",
    "국가": "한국",
    "지역": "서울",
    "채용포지션": "백엔드 주니어 개발자",
    "채용보상금": 1500000,
    "사용기술": "Python"
  },
  {
    "채용공고_id": "채용공고 id",
    "회사명": "원티드코리아",
    "국가": "한국",
    "지역": "부산",
    "채용포지션": "프론트엔드 개발자",
    "채용보상금": 500000,
    "사용기술": "javascript"
  }
]
```

<br>

**Example 2 : `some/url?search=Django`** 
```json
[
  {
    "채용공고_id": "채용공고 id",
    "회사명": "네이버",
    "국가": "한국",
    "지역": "판교",
    "채용포지션": "Django 백엔드 개발자",
    "채용보상금": 1000000,
    "사용기술": "Django"
  },
  {
    "채용공고_id": "채용공고 id",
    "회사명": "카카오",
    "국가": "한국",
    "지역": "판교",
    "채용포지션": "Django 백엔드 개발자",
    "채용보상금": 500000,
    "사용기술": "Python"
  }
]
```

<br>

### 5. 채용 상세 페이지를 가져옵니다.
> ➡️ 사용자는 채용상세 페이지를 아래와 같이 확인할 수 있습니다.  
> - “채용내용”이 추가적으로 담겨있음.
> - 해당 회사가 올린 다른 채용공고 가 추가적으로 포함됩니다(**선택사항 및 가산점요소**).

```json
{
    "채용공고_id": "채용공고 id",
    "회사명":"원티드랩",
    "국가":"한국",
    "지역":"서울",
    "채용포지션":"백엔드 주니어 개발자",
    "채용보상금":1500000,
    "사용기술":"Python",
    "채용내용": "원티드랩에서 백엔드 주니어 개발자를 채용합니다. 자격요건은..",
    "회사가올린다른채용공고": ["채용공고 id", "채용공고 id", ...] //id List (선택사항 및 가산점요소).
}
```

<br>

### 6. 사용자는 채용공고에 지원합니다(선택사항 및 가산점요소).
> ➡️ 사용자는 채용공고에 아래와 같이 지원합니다. (가점 요소이며, 필수 구현 요소가 아님)  
> - 사용자는 1회만 지원 가능합니다.

```json
{
    "채용공고_id": "채용공고 id",
    "사용자_id": "사용자 id"
}
```

<br>
<br>