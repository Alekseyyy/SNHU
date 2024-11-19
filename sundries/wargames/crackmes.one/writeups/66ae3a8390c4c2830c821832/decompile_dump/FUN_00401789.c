undefined8 FUN_00401789(void)

{
  undefined8 uVar1;
  longlong **pplVar2;
  void **ppvVar3;
  int **ppiVar4;
  void *local_108 [4];
  void *local_e8 [4];
  longlong *local_c8 [4];
  void *local_a8 [6];
  void *local_78 [6];
  void *local_48 [5];
  undefined8 local_1d;
  
  FUN_0040b410();
  SetConsoleTitleA("bxtumations crackme");
  FUN_00460b70();
  FUN_00490b10((longlong *)local_a8,"please enter the key:\n");
  FUN_00401766(local_a8);
  FUN_00491060(local_a8);
  FUN_00460ba0();
  FUN_00490cf0((longlong *)local_c8);
  FUN_00460b70();
  FUN_00490b10((longlong *)local_e8,"331");
  FUN_00460ba0();
  local_1d._1_4_ = 0x16;
  ppiVar4 = (int **)0x16;
  FUN_00401639((longlong *)local_108,local_e8,0x16);
  while( true ) {
    FUN_004a0e90(&DAT_004a6860,local_c8);
    ppvVar3 = local_108;
    pplVar2 = local_c8;
    uVar1 = FUN_0049fbe0(pplVar2,ppvVar3);
    if ((char)uVar1 != '\0') break;
    FUN_00401560();
    FUN_00460b70();
    FUN_00490b10((longlong *)local_78,"wrong key!!");
    FUN_00401766(local_78);
    FUN_00491060(local_78);
    FUN_00460ba0();
    FUN_00460b70();
    ppiVar4 = (int **)&local_1d;
    FUN_00490b10((longlong *)local_48,"\ntry again :))\n");
    FUN_00401766(local_48);
    FUN_00491060(local_48);
    FUN_00460ba0();
  }
  DAT_004d1030 = 1;
  FUN_0040157b(pplVar2,ppvVar3,ppiVar4);
  FUN_00491060(local_108);
  FUN_00491060(local_e8);
  FUN_00491060(local_c8);
  return 0;
}


