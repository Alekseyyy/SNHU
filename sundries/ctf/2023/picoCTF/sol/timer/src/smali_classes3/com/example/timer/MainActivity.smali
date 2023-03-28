.class public final Lcom/example/timer/MainActivity;
.super Landroidx/appcompat/app/AppCompatActivity;
.source "MainActivity.kt"


# annotations
.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u001b\u001a\u00020\u001c2\u0008\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0014J\u0010\u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020!H\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006\"\u0004\u0008\u0007\u0010\u0008R\u001a\u0010\t\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\u0008\n\u0010\u0006\"\u0004\u0008\u000b\u0010\u0008R\u001a\u0010\u000c\u001a\u00020\rX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\u0008\u000e\u0010\u000f\"\u0004\u0008\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\u0008\u0013\u0010\u0006\"\u0004\u0008\u0014\u0010\u0008R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\u0008\u0017\u0010\u0018\"\u0004\u0008\u0019\u0010\u001a\u00a8\u0006\""
    }
    d2 = {
        "Lcom/example/timer/MainActivity;",
        "Landroidx/appcompat/app/AppCompatActivity;",
        "()V",
        "hours",
        "Landroid/widget/EditText;",
        "getHours",
        "()Landroid/widget/EditText;",
        "setHours",
        "(Landroid/widget/EditText;)V",
        "minutes",
        "getMinutes",
        "setMinutes",
        "playbtn",
        "Landroid/widget/Button;",
        "getPlaybtn",
        "()Landroid/widget/Button;",
        "setPlaybtn",
        "(Landroid/widget/Button;)V",
        "seconds",
        "getSeconds",
        "setSeconds",
        "textView",
        "Landroid/widget/TextView;",
        "getTextView",
        "()Landroid/widget/TextView;",
        "setTextView",
        "(Landroid/widget/TextView;)V",
        "onCreate",
        "",
        "savedInstanceState",
        "Landroid/os/Bundle;",
        "startCountingDown",
        "starttime",
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
.field public hours:Landroid/widget/EditText;

.field public minutes:Landroid/widget/EditText;

.field public playbtn:Landroid/widget/Button;

.field public seconds:Landroid/widget/EditText;

.field public textView:Landroid/widget/TextView;


# direct methods
.method public static synthetic $r8$lambda$PaGgl30BGgP1q6Fbh5HIuol1kdQ(Lcom/example/timer/MainActivity;Landroid/view/View;)V
    .locals 0

    invoke-static {p0, p1}, Lcom/example/timer/MainActivity;->onCreate$lambda-0(Lcom/example/timer/MainActivity;Landroid/view/View;)V

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .line 13
    invoke-direct {p0}, Landroidx/appcompat/app/AppCompatActivity;-><init>()V

    return-void
.end method

.method private static final onCreate$lambda-0(Lcom/example/timer/MainActivity;Landroid/view/View;)V
    .locals 5
    .param p0, "this$0"    # Lcom/example/timer/MainActivity;
    .param p1, "it"    # Landroid/view/View;

    const-string v0, "this$0"

    invoke-static {p0, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 39
    invoke-virtual {p0}, Lcom/example/timer/MainActivity;->getHours()Landroid/widget/EditText;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    .line 40
    .local v0, "hoursentered":Ljava/lang/String;
    invoke-virtual {p0}, Lcom/example/timer/MainActivity;->getMinutes()Landroid/widget/EditText;

    move-result-object v1

    invoke-virtual {v1}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    .line 41
    .local v1, "minutesentered":Ljava/lang/String;
    invoke-virtual {p0}, Lcom/example/timer/MainActivity;->getSeconds()Landroid/widget/EditText;

    move-result-object v2

    invoke-virtual {v2}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    .line 43
    .local v2, "secondsentered":Ljava/lang/String;
    invoke-static {v0}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v3

    mul-int/lit16 v3, v3, 0xe10

    invoke-static {v1}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v4

    mul-int/lit8 v4, v4, 0x3c

    add-int/2addr v3, v4

    invoke-static {v2}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v4

    add-int/2addr v3, v4

    .line 45
    .local v3, "actual_seconds":I
    mul-int/lit16 v4, v3, 0x3e8

    invoke-direct {p0, v4}, Lcom/example/timer/MainActivity;->startCountingDown(I)V

    .line 46
    return-void
.end method

.method private final startCountingDown(I)V
    .locals 3
    .param p1, "starttime"    # I

    .line 52
    int-to-long v0, p1

    new-instance v2, Lcom/example/timer/MainActivity$startCountingDown$1;

    invoke-direct {v2, p0, v0, v1}, Lcom/example/timer/MainActivity$startCountingDown$1;-><init>(Lcom/example/timer/MainActivity;J)V

    .line 92
    invoke-virtual {v2}, Lcom/example/timer/MainActivity$startCountingDown$1;->start()Landroid/os/CountDownTimer;

    .line 93
    return-void
.end method


# virtual methods
.method public final getHours()Landroid/widget/EditText;
    .locals 1

    .line 18
    iget-object v0, p0, Lcom/example/timer/MainActivity;->hours:Landroid/widget/EditText;

    if-eqz v0, :cond_0

    return-object v0

    :cond_0
    const-string v0, "hours"

    invoke-static {v0}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    const/4 v0, 0x0

    return-object v0
.end method

.method public final getMinutes()Landroid/widget/EditText;
    .locals 1

    .line 17
    iget-object v0, p0, Lcom/example/timer/MainActivity;->minutes:Landroid/widget/EditText;

    if-eqz v0, :cond_0

    return-object v0

    :cond_0
    const-string v0, "minutes"

    invoke-static {v0}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    const/4 v0, 0x0

    return-object v0
.end method

.method public final getPlaybtn()Landroid/widget/Button;
    .locals 1

    .line 15
    iget-object v0, p0, Lcom/example/timer/MainActivity;->playbtn:Landroid/widget/Button;

    if-eqz v0, :cond_0

    return-object v0

    :cond_0
    const-string v0, "playbtn"

    invoke-static {v0}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    const/4 v0, 0x0

    return-object v0
.end method

.method public final getSeconds()Landroid/widget/EditText;
    .locals 1

    .line 16
    iget-object v0, p0, Lcom/example/timer/MainActivity;->seconds:Landroid/widget/EditText;

    if-eqz v0, :cond_0

    return-object v0

    :cond_0
    const-string v0, "seconds"

    invoke-static {v0}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    const/4 v0, 0x0

    return-object v0
.end method

.method public final getTextView()Landroid/widget/TextView;
    .locals 1

    .line 14
    iget-object v0, p0, Lcom/example/timer/MainActivity;->textView:Landroid/widget/TextView;

    if-eqz v0, :cond_0

    return-object v0

    :cond_0
    const-string v0, "textView"

    invoke-static {v0}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    const/4 v0, 0x0

    return-object v0
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 3
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .line 21
    invoke-super {p0, p1}, Landroidx/appcompat/app/AppCompatActivity;->onCreate(Landroid/os/Bundle;)V

    .line 22
    const v0, 0x7f0b001c

    invoke-virtual {p0, v0}, Lcom/example/timer/MainActivity;->setContentView(I)V

    .line 25
    const v0, 0x7f0801be

    invoke-virtual {p0, v0}, Lcom/example/timer/MainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    const-string v1, "findViewById(R.id.textView)"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast v0, Landroid/widget/TextView;

    invoke-virtual {p0, v0}, Lcom/example/timer/MainActivity;->setTextView(Landroid/widget/TextView;)V

    .line 26
    const v0, 0x7f080158

    invoke-virtual {p0, v0}, Lcom/example/timer/MainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    const-string v1, "findViewById(R.id.play_btn)"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast v0, Landroid/widget/Button;

    invoke-virtual {p0, v0}, Lcom/example/timer/MainActivity;->setPlaybtn(Landroid/widget/Button;)V

    .line 27
    const v0, 0x7f08017b

    invoke-virtual {p0, v0}, Lcom/example/timer/MainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    const-string v1, "findViewById(R.id.seconds_edt_txt)"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast v0, Landroid/widget/EditText;

    invoke-virtual {p0, v0}, Lcom/example/timer/MainActivity;->setSeconds(Landroid/widget/EditText;)V

    .line 28
    const v0, 0x7f080113

    invoke-virtual {p0, v0}, Lcom/example/timer/MainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    const-string v1, "findViewById(R.id.min_edt_txt)"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast v0, Landroid/widget/EditText;

    invoke-virtual {p0, v0}, Lcom/example/timer/MainActivity;->setMinutes(Landroid/widget/EditText;)V

    .line 29
    const v0, 0x7f0800db

    invoke-virtual {p0, v0}, Lcom/example/timer/MainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    const-string v1, "findViewById(R.id.hours_edt_txt)"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast v0, Landroid/widget/EditText;

    invoke-virtual {p0, v0}, Lcom/example/timer/MainActivity;->setHours(Landroid/widget/EditText;)V

    .line 32
    invoke-virtual {p0}, Lcom/example/timer/MainActivity;->getMinutes()Landroid/widget/EditText;

    move-result-object v0

    const-string v1, "0"

    move-object v2, v1

    check-cast v2, Ljava/lang/CharSequence;

    invoke-virtual {v0, v2}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 33
    invoke-virtual {p0}, Lcom/example/timer/MainActivity;->getSeconds()Landroid/widget/EditText;

    move-result-object v0

    move-object v2, v1

    check-cast v2, Ljava/lang/CharSequence;

    invoke-virtual {v0, v2}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 34
    invoke-virtual {p0}, Lcom/example/timer/MainActivity;->getHours()Landroid/widget/EditText;

    move-result-object v0

    check-cast v1, Ljava/lang/CharSequence;

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 38
    invoke-virtual {p0}, Lcom/example/timer/MainActivity;->getPlaybtn()Landroid/widget/Button;

    move-result-object v0

    new-instance v1, Lcom/example/timer/MainActivity$$ExternalSyntheticLambda0;

    invoke-direct {v1, p0}, Lcom/example/timer/MainActivity$$ExternalSyntheticLambda0;-><init>(Lcom/example/timer/MainActivity;)V

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 47
    return-void
.end method

.method public final setHours(Landroid/widget/EditText;)V
    .locals 1
    .param p1, "<set-?>"    # Landroid/widget/EditText;

    const-string v0, "<set-?>"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 18
    iput-object p1, p0, Lcom/example/timer/MainActivity;->hours:Landroid/widget/EditText;

    return-void
.end method

.method public final setMinutes(Landroid/widget/EditText;)V
    .locals 1
    .param p1, "<set-?>"    # Landroid/widget/EditText;

    const-string v0, "<set-?>"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 17
    iput-object p1, p0, Lcom/example/timer/MainActivity;->minutes:Landroid/widget/EditText;

    return-void
.end method

.method public final setPlaybtn(Landroid/widget/Button;)V
    .locals 1
    .param p1, "<set-?>"    # Landroid/widget/Button;

    const-string v0, "<set-?>"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 15
    iput-object p1, p0, Lcom/example/timer/MainActivity;->playbtn:Landroid/widget/Button;

    return-void
.end method

.method public final setSeconds(Landroid/widget/EditText;)V
    .locals 1
    .param p1, "<set-?>"    # Landroid/widget/EditText;

    const-string v0, "<set-?>"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 16
    iput-object p1, p0, Lcom/example/timer/MainActivity;->seconds:Landroid/widget/EditText;

    return-void
.end method

.method public final setTextView(Landroid/widget/TextView;)V
    .locals 1
    .param p1, "<set-?>"    # Landroid/widget/TextView;

    const-string v0, "<set-?>"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 14
    iput-object p1, p0, Lcom/example/timer/MainActivity;->textView:Landroid/widget/TextView;

    return-void
.end method
