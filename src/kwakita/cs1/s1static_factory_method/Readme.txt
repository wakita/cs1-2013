 - BooleanMain.java:
   Boolean クラスのインスタンスを生成するにあたってコンストラクタ (new) を利用した場合と，static factory method (sfm) を使った場合の性能差を比較する例題．

 - BigInteger1.java:
   無限精度整数の機能を提供する BigInteger クラスの使い方を学ぶ例．通常ならばオーバーフローするような大きな n についての 2^n の冪乗計算できることを示している．
 
 - BigInteger2.java:
   BooleanMain と同様に static factory method の効率を学ぶ例題．
 
 - HashMapMain.java
   Generics を使ったプログラミング例．
   run1 は通常の使い方．map 変数の型宣言と初期化データの両方ともに Generics の型を与えなくてはならないために，煩雑である．
   一方，run2 では変数の型宣言は仕方ないものの，初期化データは Utils.HashMap() となっており，run1 のような面倒を避けている．