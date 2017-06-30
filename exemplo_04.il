.assembly extern mscorlib {}
.assembly exemplo_04{}
.module exemplo_04.exe

.class public _Principal{

.method static public void _principal()
 { 

	  .entrypoint

	  .locals(int64 CH)
	  r:
	  ldstr "qual a CH de compiladores? "
	  call void [mscorlib]System.Console::Write(string)
	  call string [mscorlib]System.Console::ReadLine()
	  call int64 [mscorlib]System.Int64::Parse(string)
	  stloc CH
	  ldloc CH
	  ldc.i8 17
	  cgt
	  brfalse r
	  ldstr "total de créditos: "
	  call void [mscorlib]System.Console::Write(string)
	  ldloc CH
	  ldc.i8 18
	  div
	  call void [mscorlib]System.Console::Write(int64)
	  ret
 }
}