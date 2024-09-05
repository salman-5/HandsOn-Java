public enum PaymentOptions {
    DEBIT_CARD(2),CREDIT_CARD(1);
    private float feePercent;

    PaymentOptions(float a){ this.feePercent=a;}

    float fee(float total){
        return (float) (0.01*total*feePercent);
    }
}
