# MSA/DDD/Event Storming 예제 - 음식배달

## 서비스 시나리오



## 이벤트 스토밍 결과:

http://msaez.io/#/storming/nZJ2QhwVc4NlVJPbtTkZ8x9jclF2/every/a77281d704710b0c2e6a823b6e6d973a/-M5AV2z--su_i4BfQfeF

### 과정 소개:

- 
-
-


## 구현:


### 폴리글랏 퍼시스턴스 / 플랫폼

```
cd 주문
mvn spring-boot:run  # H2
cd 결제
mvn spring-boot:run  # H2
cd 상점
mvn spring-boot:run  # MySQL 
cd 마케팅
python marketing  # 파이썬
```

### 비동기식 호출 / 시간적 디커플링 / 장애격리 / 최종 (Eventual) 일관성 테스트

```
#상점 서비스를 잠시 내려놓음
kill (lsof -i )

#주문처리
http localhost:8080/주문s 품목=통닭 수량=1 주소=서울
http localhost:8080/주문s 품목=피자 수량=2 주소=서울

#주문상태 확인
http localhost:8080/주문s     # 주문상태 안바뀜 확인

#상점 서비스 기동
cd 상점
mvn spring-boot:run

#주문상태 확인
http localhost:8080/주문s     # 모든 주문의 상태가 배송됨으로 확인
```

### 동기식 호출 / 타임 커플링 / 결제 안되면 주문도 안됨
```
# 결제 서비스를 잠시 내려놓음
kill (lsof -i)

#주문처리
http localhost:8080/주문s 품목=통닭 수량=1 주소=서울    #오류
http localhost:8080/주문s 품목=피자 수량=2 주소=서울    #오류

#결제서비스 재기동
cd 결제
mvn spring-boot:run

#주문처리
http localhost:8080/주문s 품목=통닭 수량=1 주소=서울    #성공
http localhost:8080/주문s 품목=피자 수량=2 주소=서울    #성공
```


## 운영


### 동기식 호출 / 서킷 브레이킹 / 장애격리
```
istio 
```

### 무정지 재배포
```
```

### 



```
