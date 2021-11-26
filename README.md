# 용둥지 안드로이드 템플릿

### 1. 프로젝트 세팅

> amplify 적용 방법

1. 프로젝트 폴더에서 `amplify pull --appId [ProjectId] --envName dev` 명령어 입력
2. amplify 셋팅 중 res 위치를 다음과 같이 설정 `data/src/main/res`
3. `amplify pull` 명령어 입력하여 최신으로 업데이트
3. `amplify codegen models` 입력 후 data 모듈안에 amplify 클래스 생성 확인

<del>
<br>

> 깃 훅 설정 방법

<br>

1. 프로젝트를 클론 후 실행 시키고 우측 탭에 `Gradle` 코끼리 클릭
2. 그리고 `Tasks` 폴더를 열어 `git hooks` 클릭
3. `copyGitHooks` 와 `installGitHooks` 더블클릭 하여 실행

> 만약 여기서 Tasks 가 나오지 않는다면

1. `Command` + `Shift` + `A` 클릭 후
2. `Do not build Gradle task list during Gradle sync` 입력
3. `Enter` 치고 들어가서 체크 풀기
4. 안드로이드 스튜디오 재 실행
5. 하단에 `Terminal` 열어서 `./gradlew tasks --all` 입력

---

### 2. 린트 관련

<br>

린트는 기본적으로 3가지의 린트를 사용

- ktlint : 코틀린을 위한 정적 분석
- detekt : 코드 품질을 검사
- lint   : 프로젝트 구조를 검사

깃 훅을 설정하였다면 커밋 단계에서 알아서 실행이 되지만 추가적으로 테스트를 해보고 싶다면 아래와 같이 진행

> 린트 수동으로 검사하기

1. `Command` + `Shift` + `A` 클릭 후
2. `Execute Gradle Task` 입력
3. `detekt ktlint lint` 입력 후 실행

> 추가 권장사항

- detekt 및 lintkt 는 IDE 플러그인으로 설치하여 적용가능하여 사전에 미리미리 코딩 스타일에 맞추길 추천

---

햅삐 하다
</del>

> 린트 적용 후기 : 커밋하는데 화병 나 돌아가실 것 같음