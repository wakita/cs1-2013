package kwakita.cs1.s2builder;

import java.util.*;

class ABPerson {
  String name, yomi, phone, email, birthday;

  private ABPerson(Builder b) {
    this.name = b.name;
    this.yomi = b.yomi;
    this.phone = b.phone;
    this.email = b.email;
    this.birthday = b.birthday;
  }

  public String toString() {
    List<String> output = new ArrayList<String>();
    output.add("Name: " + name);
    output.add("Yomi: " + yomi);
    output.add("Phone: " + phone);
    output.add("Email: " + email);
    output.add("Birthday: " + birthday);
    return output.toString();
  }

  public static class Builder {
    private String name, yomi, phone, email, birthday;

    public Builder(String name) {
      this.name = name;
    }

    public Builder yomi(String x) {
      this.yomi = x;
      return this;
    }

    public Builder phone(String x) {
      this.phone = x;
      return this;
    }

    public Builder email(String x) {
      this.email = x;
      return this;
    }

    public Builder birthday(String x) {
      this.birthday = x;
      return this;
    }

    public Builder(Builder b) {
      this.name = b.name;
      this.yomi = b.yomi;
      this.phone = b.phone;
      this.email = b.email;
      this.birthday = b.birthday;
    }

    public ABPerson build() {
      return new ABPerson(this);
    }
  }
}
