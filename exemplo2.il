.assembly extern mscorlib {}
.assembly exemplo2{}
.module exemplo2.exe

.class public _Principal{

.method static public void _principal()
 { .entrypoint
  ldc.i8 1
  ldc.i8 3
  clt
  ldc.i4.0
  ceq
  call void [mscorlib]System.Console::Write(bool)
  ldc.r8 3.0
  ldc.i8 3
  clt
  ldc.i4.0
  ceq
  call void [mscorlib]System.Console::Write(bool)
  ldc.i8 1
  ldc.i8 3
  cgt
  ldc.i4.0
  ceq
  call void [mscorlib]System.Console::Write(bool)
  ldc.i8 3
  ldc.i8 3
  cgt
  ldc.i4.0
  ceq
  call void [mscorlib]System.Console::Write(bool)
  ldc.i8 4
  ldc.i8 3
  cgt
  ldc.i4.1
  xor
  call void [mscorlib]System.Console::Write(bool)
  ldc.i8 3
  ldc.i8 3
  cgt
  ldc.i4.1
  xor
  call void [mscorlib]System.Console::Write(bool)
  ret
 }
}