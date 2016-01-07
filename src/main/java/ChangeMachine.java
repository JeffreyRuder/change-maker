public class ChangeMachine {

  private Integer mQuartersAvailable = 0;
  private Integer mDimesAvailable = 0;
  private Integer mNickelsAvailable = 0;
  private Integer mPenniesAvailable = 0;

  public ChangeMachine() {
    mQuartersAvailable = 0;
    mDimesAvailable = 0;
    mNickelsAvailable = 0;
    mPenniesAvailable = 10000;
  }

  public ChangeMachine (Integer quarters, Integer dimes, Integer nickels) {
    mQuartersAvailable = quarters;
    mDimesAvailable = dimes;
    mNickelsAvailable = nickels;
    mPenniesAvailable = 10000;
  }

  public Integer getQuarters() {
    return mQuartersAvailable;
  }

  public Integer getNickels() {
    return mQuartersAvailable;
  }

  public Integer getDimes() {
    return mQuartersAvailable;
  }

  public void addQuarters(Integer quarters) {
    mQuartersAvailable += quarters;
  }

  public void addDimes(Integer dimes) {
    mDimesAvailable += dimes;
  }

  public void addNickels(Integer nickels) {
    mNickelsAvailable += nickels;
  }

}
