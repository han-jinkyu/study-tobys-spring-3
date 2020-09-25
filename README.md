# study-tobys-spring-3
책 '토비의 스프링 3.1'을 읽으면서 해보는 실습

## 책 구매
- [리디북스](https://ridibooks.com/books/111017526)

---

## 스프링이란?

- 자바 엔터프라이즈 애플리케이션 개발에 사용되는 애플리케이션 프레임워크.
  
### 애플리케이션의 기본 툴 - 스프링 컨테이너

- `스프링 컨테이너` 또는 `애플리케이션 컨텍스트`라 불리는 스프링 런타임 엔진 제공.
- 설정 정보를 참고하여 애플리케이션을 구성하는 `오브젝트를 생성하고 관리`.
- 독립적으로 동작할 수 있지만 보통 웹 모듈에서 동작하는 서비스나 서블릿으로 등록해서 사용.
  
### 공통 프로그래밍 모델 - IoC/DI, 서비스 추상화, AOP

- 프레임워크는 애플리케이션을 구성하는 오브젝트가 생성되고 동작하는 방식에 대한 `틀을 제공`하고, 애플리케이션 코드가 `어떻게 작성돼야 하는지에 대한 기준도 제시`한다.
- 이런 틀을 보통 `프로그래밍 모델`이라 한다.
- 스프링은 다음 세 가지 프로그래밍 모델을 가지고 있다.
  1. `IoC/DI`
     - 오브젝트의 `생명주기와 의존관계`에 대한 프로그래밍 모델. 
     - 스프링의 근간.
  2. `서비스 추상화`
     - 구체적인 기술과 환경에 종속되지 않도록 유연한 `추상 계층`을 두는 방법.
  3. `AOP`
     - 애플리케이션 코드에 산재해서 나타나는 부가적인 기능을 `독립적으로 모듈화`하는 프로그래밍 모델.

### 기술 API

- 엔터프라이즈 애플리케이션을 개발의 다양한 영역에 바로 활용할 수 있는 `방대한 양의 기술 API를 제공`한다.
- 스프링이 제공하는 API와 지원 기술은 모두 스프링의 프로그래밍 모델에 따라 작성되어 있기 때문에, 가져다 쓰는 것만으로 프로그래밍 모델을 코드에 자연스럽게 적용할 수 있다.
- 모든 기술은 표준 자바 엔터프라이즈 플랫폼(Java EE)에 기반을 두고 있다.

---

1. [오브젝트와 의존관계](./Chapter01/docs/index.md)
2. [테스트](./Chapter02/docs/index.md)
3. [템플릿](./Chapter03/docs/index.md)
4. [예외](./Chapter04/docs/index.md)
5. [서비스 추상화](./Chapter05/docs/index.md)
6. [AOP](./Chapter06/docs/index.md)
