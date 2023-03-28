.class public final Lcom/example/timer/MainActivity$startCountingDown$1;
.super Landroid/os/CountDownTimer;
.source "MainActivity.kt"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/example/timer/MainActivity;->startCountingDown(I)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = null
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0008\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\u0007"
    }
    d2 = {
        "com/example/timer/MainActivity$startCountingDown$1",
        "Landroid/os/CountDownTimer;",
        "onFinish",
        "",
        "onTick",
        "millisUntilFinished",
        "",
        "app_debug"
    }
    k = 0x1
    mv = {
        0x1,
        0x6,
        0x0
    }
    xi = 0x30
.end annotation


# instance fields
.field final synthetic this$0:Lcom/example/timer/MainActivity;


# direct methods
.method constructor <init>(Lcom/example/timer/MainActivity;J)V
    .locals 2
    .param p1, "$receiver"    # Lcom/example/timer/MainActivity;
    .param p2, "$super_call_param$1"    # J

    iput-object p1, p0, Lcom/example/timer/MainActivity$startCountingDown$1;->this$0:Lcom/example/timer/MainActivity;

    .line 52
    const-wide/16 v0, 0x3e8

    invoke-direct {p0, p2, p3, v0, v1}, Landroid/os/CountDownTimer;-><init>(JJ)V

    return-void
.end method


# virtual methods
.method public onFinish()V
    .locals 2

    .line 90
    iget-object v0, p0, Lcom/example/timer/MainActivity$startCountingDown$1;->this$0:Lcom/example/timer/MainActivity;

    invoke-virtual {v0}, Lcom/example/timer/MainActivity;->getTextView()Landroid/widget/TextView;

    move-result-object v0

    const-string v1, "done!"

    check-cast v1, Ljava/lang/CharSequence;

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 91
    return-void
.end method

.method public onTick(J)V
    .locals 15
    .param p1, "millisUntilFinished"    # J

    .line 56
    move-object v0, p0

    const/16 v1, 0x3e8

    int-to-long v1, v1

    div-long v1, p1, v1

    .line 57
    .local v1, "seconds_remaining":J
    const-wide/16 v3, 0x0

    .line 58
    .local v3, "hours_remaining":J
    const-wide/16 v5, 0x0

    .line 59
    .local v5, "sec_remaining":J
    const/4 v7, 0x0

    .line 60
    .local v7, "minutes_remaining":I
    const-wide/16 v8, 0x3c

    const-string v10, "0"

    cmp-long v11, v1, v8

    if-gez v11, :cond_0

    .line 61
    iget-object v11, v0, Lcom/example/timer/MainActivity$startCountingDown$1;->this$0:Lcom/example/timer/MainActivity;

    invoke-virtual {v11}, Lcom/example/timer/MainActivity;->getSeconds()Landroid/widget/EditText;

    move-result-object v11

    invoke-static {v1, v2}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v12

    check-cast v12, Ljava/lang/CharSequence;

    invoke-virtual {v11, v12}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 62
    iget-object v11, v0, Lcom/example/timer/MainActivity$startCountingDown$1;->this$0:Lcom/example/timer/MainActivity;

    invoke-virtual {v11}, Lcom/example/timer/MainActivity;->getMinutes()Landroid/widget/EditText;

    move-result-object v11

    move-object v12, v10

    check-cast v12, Ljava/lang/CharSequence;

    invoke-virtual {v11, v12}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 63
    iget-object v11, v0, Lcom/example/timer/MainActivity$startCountingDown$1;->this$0:Lcom/example/timer/MainActivity;

    invoke-virtual {v11}, Lcom/example/timer/MainActivity;->getHours()Landroid/widget/EditText;

    move-result-object v11

    move-object v12, v10

    check-cast v12, Ljava/lang/CharSequence;

    invoke-virtual {v11, v12}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 65
    :cond_0
    const-wide/16 v11, 0xe10

    const/16 v13, 0x3c

    cmp-long v14, v1, v8

    if-lez v14, :cond_1

    cmp-long v8, v1, v11

    if-gez v8, :cond_1

    .line 67
    long-to-int v8, v1

    div-int/lit8 v7, v8, 0x3c

    .line 68
    int-to-long v8, v13

    rem-long v5, v1, v8

    .line 69
    iget-object v8, v0, Lcom/example/timer/MainActivity$startCountingDown$1;->this$0:Lcom/example/timer/MainActivity;

    invoke-virtual {v8}, Lcom/example/timer/MainActivity;->getSeconds()Landroid/widget/EditText;

    move-result-object v8

    invoke-static {v5, v6}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v9

    check-cast v9, Ljava/lang/CharSequence;

    invoke-virtual {v8, v9}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 70
    iget-object v8, v0, Lcom/example/timer/MainActivity$startCountingDown$1;->this$0:Lcom/example/timer/MainActivity;

    invoke-virtual {v8}, Lcom/example/timer/MainActivity;->getMinutes()Landroid/widget/EditText;

    move-result-object v8

    invoke-static {v7}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v9

    check-cast v9, Ljava/lang/CharSequence;

    invoke-virtual {v8, v9}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 71
    iget-object v8, v0, Lcom/example/timer/MainActivity$startCountingDown$1;->this$0:Lcom/example/timer/MainActivity;

    invoke-virtual {v8}, Lcom/example/timer/MainActivity;->getHours()Landroid/widget/EditText;

    move-result-object v8

    check-cast v10, Ljava/lang/CharSequence;

    invoke-virtual {v8, v10}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 73
    :cond_1
    cmp-long v8, v1, v11

    if-ltz v8, :cond_2

    .line 75
    const/16 v8, 0xe10

    int-to-long v8, v8

    div-long v3, v1, v8

    .line 76
    rem-long v5, v1, v8

    .line 77
    long-to-int v8, v5

    div-int/lit8 v7, v8, 0x3c

    .line 78
    int-to-long v8, v13

    rem-long/2addr v5, v8

    .line 80
    iget-object v8, v0, Lcom/example/timer/MainActivity$startCountingDown$1;->this$0:Lcom/example/timer/MainActivity;

    invoke-virtual {v8}, Lcom/example/timer/MainActivity;->getSeconds()Landroid/widget/EditText;

    move-result-object v8

    invoke-static {v5, v6}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v9

    check-cast v9, Ljava/lang/CharSequence;

    invoke-virtual {v8, v9}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 81
    iget-object v8, v0, Lcom/example/timer/MainActivity$startCountingDown$1;->this$0:Lcom/example/timer/MainActivity;

    invoke-virtual {v8}, Lcom/example/timer/MainActivity;->getMinutes()Landroid/widget/EditText;

    move-result-object v8

    invoke-static {v7}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v9

    check-cast v9, Ljava/lang/CharSequence;

    invoke-virtual {v8, v9}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 82
    iget-object v8, v0, Lcom/example/timer/MainActivity$startCountingDown$1;->this$0:Lcom/example/timer/MainActivity;

    invoke-virtual {v8}, Lcom/example/timer/MainActivity;->getHours()Landroid/widget/EditText;

    move-result-object v8

    invoke-static {v3, v4}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v9

    check-cast v9, Ljava/lang/CharSequence;

    invoke-virtual {v8, v9}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 84
    :cond_2
    iget-object v8, v0, Lcom/example/timer/MainActivity$startCountingDown$1;->this$0:Lcom/example/timer/MainActivity;

    invoke-virtual {v8}, Lcom/example/timer/MainActivity;->getTextView()Landroid/widget/TextView;

    move-result-object v8

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string v10, "seconds remaining: "

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v9, v1, v2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    check-cast v9, Ljava/lang/CharSequence;

    invoke-virtual {v8, v9}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 85
    return-void
.end method
