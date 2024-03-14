# ✨프로젝트 소개
### **🥄MAT.Zip**  - 리뷰 기반 맛집 정보 탐색 사이트🥢
###### 맛집 정보를 압축해서 보여준다는 중의적인 의미를 담은 이름
   
#### 팀 : JAVA GIRLS (4)

#### 프로젝트 기간 : 24.01.23 ~ 24.03.11


#### Github : https://github.com/JAVA-GIRLS/matzip   



<br>  

## 🛠️개발 도구 및 환경


- **Java**
- **Oracle (DB)**
- **Spring Framework (Spring Boot)**
- **JPA**

### 
- **HTML**
- **CSS**
- **JavaScript**
- **Thymeleaf**
- **Bootstrap**
#### - 형상관리
- **Git**
- **GitHub**

#### - 인프라
- **AWS(Nginx)**
- **AWS S3**

#### - 개발 환경 및 툴
- **Eclipse(IDE)**
- **Notion**

<br>  <br>  



## 🎯 담당 업무
1. **AWS S3 업로더 (CRD)**
    - <u>S3Utility</u>를 활용, 이미지 업로드/삭제 기능 구현
    - 이미지 업로드 시  UUID를 사용하여 고유 파일명 생성
    - 업로드할 이미지의 파일 확장자 허용 여부 확인
2. **리뷰 CRUD**
    -  해시태그를 통해 해당하는 식당에 알맞은 리뷰와 해시태그를 조회할 수 있도록 구현
    -  캐러셀 활용, 이미지 슬라이드 기능 구현
3. **Entity 설계**
4. **Error Controller** (주요 에러 처리)

 <br>

##### * 해시태그와 레스토랑은 다대다 관계로, Delete 기능에서 해시태그에 리뷰가 하나도 연결되지 않은 상태에서만 삭제할 수 있도록 처리
##### * 리뷰 작성과 수정 시 등록되는 이미지들은 S3 버킷에 저장, 리뷰 삭제 시 해당 이미지 파일도 함께 삭제되도록 구현

 

<br>   

## 💻화면

###  ✅리뷰 작성
- 평점 마우스 오버. 클릭시 고정

![1  별 마우스오버](https://github.com/gyeommii/gyeommii.github.io/assets/145918939/67b1a750-d0d4-423d-ad8f-856875ad8972)

<br>

- 이미지 파일 선택&미리보기 / 텍스트

![2  이미지 텍스트](https://github.com/gyeommii/gyeommii.github.io/assets/145918939/f8a4feb2-e4a8-4116-8a55-e5da4781da48)   

<br>

- 카테고리별 해시태그

![3 해시태그](https://github.com/gyeommii/gyeommii.github.io/assets/145918939/fed0a90e-3eda-48eb-960e-0e9e94273541)
<br>   

###  ✅리뷰 수정 / 삭제 
- 수정

![리뷰수정](https://github.com/gyeommii/gyeommii.github.io/assets/145918939/b7cd5eb0-3df7-4435-b5a5-f8da7c8bc9e2)

<br>

- 삭제

![리뷰삭제](https://github.com/gyeommii/gyeommii.github.io/assets/145918939/1ee1e065-0dee-4673-bf8b-c2d4a494d129)

<br>

### ✅ 해시태그 / 이미지 캐러셀&모달

![해시태그 이미지캐러샐모달](https://github.com/gyeommii/gyeommii.github.io/assets/145918939/9c388a26-5bb4-4246-b203-b6e9ce29f3c1)

<br>

### ✅ 리뷰 좋아요

![리뷰좋아요](https://github.com/gyeommii/gyeommii.github.io/assets/145918939/6a55d2f8-abd3-46b1-b6b6-f6c6a40af529)

##### * 리뷰 작성시 평점과 리뷰내용은 필수 입력
##### * 리뷰 수정 중 기존 내용에 변경사항이 있다면 페이지 벗어날때 alert창을 띄워 페이지 이동으로 인한 작성 내용 리셋 방지
##### * 총 평점은 소수점 한자리가 0.5 이상인 경우 별 반개로 표시

