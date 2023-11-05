# kotlin-lotto

# Step 1, 문자열 덧셈 계산기

## 🎯 기능 요구사항

- 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환 (예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6)
- 앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다. 예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
- 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw 한다.

## 프로그래밍 요구 사항

- indent depth를 2를 넘지 않도록 구현.
  - Ex) while문 안에 if문이 있으면 들여쓰기는 2이다.
  - hint: indent depth를 줄이는 방법
    - 함수를 분리한다.
    - else를 사용하지 않는다.
- 함수의 길이가 10라인을 넘어가지 않도록 구현.
  - 함수가 한 가지 일만 잘 하도록 구현.

### 큰 기능 목록

- [X] 문자열을 입력받아 쉼표(,) 또는 콜론(:)을 구분자를 기준으로 분리한 각 숫자의 합을 반환한다.
- [X] 커스텀 구분자를 입력 받을 경우, 커스텀 구분자를 기준으로 분리한 각 숫자의 합을 반환한다. 
- [X] 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw 한다.

### 기능 분리 목록

- [X] 문자열을 입력 받는다.
- [X] 문자열을 쉼표(,) 또는 콜론(:)을 구분자를 기준으로 분리한다.
- [X] 문자열을 커스텀 구분자를 기준으로 분리한다.
- [X] 커스텀 구분자로 들어온 값이 단순 공백("") 일 경우, IllegalArgumentException 예외를 throw 한다. 
- [X] 할당된 구분자가 존재하지 않는 문자열이 들어올 경우, IllegalStatusException 예외를 throw 한다.
- [X] 빈 문자열을 입력 받을 경우, 0을 반환한다.
- [X] 분리된 문자열을 숫자로 변환한다. = List<String> -> Int
- [X] 매개 변수의 숫자를 모두 더해 반환한다.
- [X] 매개 변수의 숫자가 음수일 경우, RuntimeException 예외를 throw 한다.
- [X] 입력 값 중에 숫자 이외의 값이 들어올 경우, RuntimeException 예외를 throw 한다.
- [X] 커스텀 구분자를 입력 받을 경우, 커스텀 구분자를 인식할 수 있다.
- [X] , 로 구분된 커스텀 구분자를 입력 받을 경우, 모든 커스텀 구분자를 인식할 수 있다.

### 💻 Step 1, Feedback

* [X] 1.SeparatorParser.kt
* [X] 2.StringParser.kt

#### 1. SeparatorParser.kt

##### Problem
- 불필요한 null 체크가 반복됨.

##### Solution
- 엘비스 연산자를 사용하여 null 체크를 제거.

##### effect
- 코드가 간결해짐.

#### 2. StringParser.kt

##### Problem
- Seperator 관련 상수가 존재. -> StringParser 파일에 존재 하는 것은 어색함.

##### Solution
- Seperator 관련 상수 제거

##### effect
- StringParser 클래스의 역할이 더 분명해질 수 있음.

# Step 2, 로또(자동)

## 🎯 기능 요구사항
* 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
* 로또 1장의 가격은 1000원이다.

## 프로그래밍 요구사항

- 모든 기능을 TDD로 구현해 단위 테스트가 존재해야 한다.
  - 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
- indent(들여쓰기) depth를 2를 넘지 않도록 구현한다. 1까지만 허용
- 함수의 길이가 15라인을 넘어가지 않도록 구현한다.
- 기능을 구현하기 전에 README.md 파일에 구현할 기능 목록을 정리해 추가한다.
- git의 commit 단위는 앞 단계에서 README.md 파일에 정리한 기능 목록 단위로 추가한다.

### 큰 기능 목록

- [X] 로또 구입 금액을 입력 받는다.
- [ ] 로또 구입 금액에 해당하는 로또를 발급한다.
- [ ] 당첨 번호를 입력 받는다.
- [ ] 당첨 번호와 발급된 로또를 비교하여 등수를 반환한다.
- [ ] 당첨 금액을 참고해 수익률을 계산한다.
- [ ] 당첨 통계를 출력한다.

### 기능 분리 목록

- [X] Int 타입 값을 받는 함수를 만든다.
- [X] String 타입 값을 받는 함수를 만든다.
- [X] 로또는 6개의 숫자를 가진다.
- [X] 로또는 1 ~ 45 사이의 숫자를 가진다.
- [X] 로또는 중복된 숫자를 가질 수 없다.
- [X] 로또를 구입할 수 있다.
- [X] 로또의 결과를 반환한다.
- [X] 수익률을 계산할 수 있다.
- [X] 당첨 통계를 출력할 수 있다.