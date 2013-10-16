package kwakita.cs1.lecture02;

import java.util.ArrayList;
import java.util.List;

public class StudentLife {
  // さて，以下のようなありがちなデータ構造があるとしよう．
  class Club {
    List<String> members = new ArrayList<String>();
  }
  List<Club> clubs = new ArrayList<Club>();
  List<String> users = new ArrayList<String>();
  
  // 例 1
  // このデータ構造に対してありがちなコードを書いたところ，ありがちなバグが混入してしまった．君はバグを見つけられるか？
  void printMembershipBug() {
    for (int i = 0; i < clubs.size(); i++) {
      for (int j = 0; j < clubs.get(i).members.size(); j++) {
        for (int k = 0; k < users.size(); k++) {
          if (clubs.get(i).members.get(k) == users.get(j)) {
            System.out.printf("User[%d] belongs to club %d.", j, i);
          }
        }
      }
    }
  }

  // 苦労してバグを見つけて修正したのがこれ．
  void printMembershipOk() {
    for (int i = 0; i < clubs.size(); i++) {
      for (int j = 0; j < clubs.get(i).members.size(); j++) {
        for (int k = 0; k < users.size(); k++) {
          if (clubs.get(i).members.get(j) == users.get(k)) {
            System.out.printf("User[%d] belongs to club %d.", j, i);
          }
        }
      }
    }
  }

  // 例 2
  // 三重ルームのループ変数に安易な名前づけをすると上のようにバグの発見が難しい．今度は，内容がわかるように名前を変更してみた．
  // 今度は見る人が見れば，さきほどのバグが一目瞭然になった．君らにも一目瞭然になってもらいたい．
  void printMembershipReadableBug() {
    for (int club_i = 0; club_i < clubs.size(); club_i++) {
      for (int member_i = 0; member_i < clubs.get(club_i).members.size(); member_i++) {
        for (int user_i = 0; user_i < users.size(); user_i++) {
          if (clubs.get(club_i).members.get(user_i) == users.get(member_i)) {
            System.out.printf("User[%d] belongs to club %d.", member_i, club_i);
          }
        }
      }
    }
  }

  // プログラムがわかりやすいとバグの発見と修正は簡単になる．
  void printMembershipReadable() {
    for (int club_i = 0; club_i < clubs.size(); club_i++) {
      for (int member_i = 0; member_i < clubs.get(club_i).members.size(); member_i++) {
        for (int user_i = 0; user_i < users.size(); user_i++) {
          if (clubs.get(club_i).members.get(member_i) == users.get(user_i)) {
            System.out.printf("User[%d] belongs k club %d.", member_i, club_i);
          }
        }
      }
    }
  }

  // 例 3
  // とはいえ，さっきの変数名は長すぎるかもしれない．そこで，変数名の長さと可読性の妥協点を探った例が次
  // club_i → ci, member_j → mi, user_i → ui
  void printMembershipReadableConcise() {
    for (int ci = 0; ci < clubs.size(); ci++) {
      for (int mi = 0; mi < clubs.get(ci).members.size(); mi++) {
        for (int ui = 0; ui < users.size(); ui++) {
          if (clubs.get(ci).members.get(mi) == users.get(ui)) {
            System.out.printf("User[%d] belongs to club %d.", ui, ci);
          }
        }
      }
    }
  }

  
  // 例 4
  // もしもデータ構造を走査するための ForIn 構文を利用すれば，そもそもループ変数など使わなくてもよかった．
  void printMembershipForIn() {
    for (Club club : clubs) {
      for (String member : club.members) {
        for (String user : users) {
          if (member == user) {
            System.out.printf("User[%s] belongs to club %s", user, club);
          }
        }
      }
    }
  }
}
