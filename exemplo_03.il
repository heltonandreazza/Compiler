.assembly extern mscorlib {}
.assembly exemplo_03{}
.module exemplo_03.exe

.class public _Principal{

.method static public void _principal()
 { .entrypoint
	  .locals (int64 area,int64 lado)
	  ldc.i8 0
	  stloc area
	  ldstr "digite um valor para lado: "
	  call void [mscorlib]System.Console::Write(string)
	  call string [mscorlib]System.Console::ReadLine()
	  call int64 [mscorlib]System.Int64::Parse(string)
	  stloc lado
	  ldloc lado
	  ldc.i8 0
	  cgt
	  brfalse r0
	  ldloc lado
	  ldloc lado
	  mul
	  stloc area
	  br r1
	  r0:
	  ldstr "valor inválido para lado - "
	  call void [mscorlib]System.Console::Write(string)
	  r1:
	  ldstr "área: "
	  call void [mscorlib]System.Console::Write(string)
	  ldloc area
	  call void [mscorlib]System.Console::Write(int64)
	  ret
 }
}