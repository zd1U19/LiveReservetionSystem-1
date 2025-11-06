<h1>ライブ予約管理システム（Live Reservetion System）</h1>

<h2>概要</h2>
ライブイベントの予約を簡単に管理できるWebシステムです。<br>
ユーザーはログイン不要でライブ予約ができ、管理者はログイン後に予約情報を確認・編集・削除できます。<br>
学習開始から3ヶ月で職業訓練校の制作授業の制限時間内に動くシステムの開発を意識して分かりやすく簡潔な構築を意識しました。<br>

<h2>目的</h2>
ライブイベントの予約を簡単に行えるようにするために開発しました。<br>  
管理者は予約状況を一目で把握でき、ユーザーはログイン不要で予約できます。<br>

<h2>背景</h2>
親族のライブ集客管理の様子が大変と聞いていたため、QOL向上を望めるシステム開発を志しました。

<h2>特徴</h2>
・一般ユーザー：ライブ情報一覧・予約フォーム<br>
・管理者：ログイン後にライブ情報・予約情報の管理（CRUD機能）<br>
・入力バリデーション・エラーメッセージ表示対応<br>

<h2>動作デモ動画</h2>
YouTube
https://youtu.be/2SxgFwvMGRs


<h2>使用技術</h2>
言語 | Java / HTML / CSS / JavaScript |<br>
フレームワーク | MyBatis / Spring Boot / Thymeleaf |<br>
データベース | MySQL |<br>
ビルドツール | Maven |<br>
フロントエンドUI | Bootstrap 5 |<br>
IDE | Eclipse / VS Code |<br>

<h2>構成</h2>
LiveReservationSystem-1/<br>
├─ src/<br>
│ ├─ main/java/<br>
│ │ ├─com/example.app/<br>
│ │ │ ├─ config/ <br>
│ │ │ ├─ controller/<br> 
│ │ │ ├─ domain/ <br>
│ │ │ ├─ filter/ <br>
│ │ │ ├─ mapper/ <br>
│ │ │ └─ service/ <br>
│ ├─ main/resources/<br>
│ │ ├─ images<br>
│ │ ├─ mybatis<br>
│ │ ├─ static<br>
│ │ └─ templates<br>
│ └─ test<br>
├─ pom.xml <br>
└─ README.md<br>

<h2>開発環境</h2>
- OS：Windows 11<br>
- IDE：Eclipse 2024-12<br>
- 言語：Java 21, HTML, CSS, JavaScript<br>
- フレームワーク：Spring Boot 3.5.4 / MyBatis / Thymeleaf<br>
- ビルドツール：Maven<br>
- DB：MySQL 8.0


