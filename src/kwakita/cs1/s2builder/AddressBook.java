package kwakita.cs1.s2builder;

public class AddressBook {
  private void run() {
    ABPerson.Builder nobody =
        (new ABPerson.Builder("名無しのゴンベイ")
        .yomi("ななしのごんべい").birthday("不明").email("ないかも")
        .phone("なくしちゃったかも"));
    ABPerson gombei = nobody.build();
    System.out.println(gombei);

    ABPerson kwakita =
        (new ABPerson.Builder(nobody).yomi("わきたけん").build());
    // nobody.yomi("わきたけん").build() としなかった理由について考えなさい。
    System.out.println(kwakita);
  }

  public static void main(String[] _) {
    new AddressBook().run();
  }
}
