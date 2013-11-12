PhoneNumber* は，「値クラス」の実装について特に hashCode メソッドの重要性を学ぶための例です．

PhoneNumber?.java は電話番号を実装したクラスです．
  - PhoneNumber1 単純な実装．equalsメソッドとhashCodeメソッドを実装していない．
  - PhoneNumber2 = PhoneNumber1 + equals．
  - PhoneNumber3 = PhoneNumber1 + hashCode．
  - PhoneNumber4 = PhoneNumber1 + equals + hashCode．
  - PhoneNumber5 = PhoneNumber1 + equals + hashCode．hashCode の実装がしょぼい．

PhoneNumber インタフェイスは PhoneNumber? クラスたちをひとまとめに扱うためのインタフェイスです．

PhoneNumberTests クラスは三種類の実装を比較するために JUnit を用いて記述した単体テストです．さまざまなテストを施します．
