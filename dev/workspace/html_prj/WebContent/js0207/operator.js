// 한줄 주석

/*
	여러줄 주석
	최 단산쉬 관리 삼대 콤마
*/


/*
 * 1. 단항 연산자 : 연산에 필요한 항이 한개인 연산자(unary):
 *		~(tilde) : 1의 보수 연산(0->1, 1->0 으로 변경)
 *		!(not) : true->false, false->true
 *		+:형식적 제공
 *		-:부호바꿈연산자, 2의 보수 연산자
 *
 *		-전위 연산
 *		연산자 대상체
 *
 *		-후위 연산
 *		대상체 연산자
 */

var num1 = 2;
var num2 = -2;

var flag1 = true;
var flag2 = false;

// window는 최상위 객체로 생략하여 사용할 수 있다.
// window.document.write();
document.write("<ul>");
document.write("<li>할당된 값 : "+num1+"</li>");
document.write("<li><strong>단항 연산자</strong></li>");
// ~양수 : 부호가 변경되고 1증가
// 0000 0000 0000 0000 0000 0000 0000 0010 : 2
// 1111 1111 1111 1111 1111 1111 1111 1101 : -3

document.write("<li> ~"+num1+"="+(~num1)+"</li>"); // -3

// ~음수 : 부호가 변경되고 1감소
document.write("<li> ~"+num2+"="+(~num2)+"</li>"); // 1

// !
document.write("<li> !"+flag1+"="+(!flag1)+"</li>"); // false
document.write("<li> !"+flag2+"="+(!flag2)+"</li>"); // true

// +
document.write("<li> +"+num1+"="+(+num1)+"</li>"); // 2
document.write("<li> +"+num2+"="+(+num2)+"</li>"); // -2

// -
document.write("<li> -"+num1+"="+(-num1)+"</li>"); // -2
document.write("<li> -"+num2+"="+(-num2)+"</li>"); // 2

// ++ : 대상체의 값을 1씩 증가
num1++; // 후위
++num1; // 전위

document.write("<li>증가연산 후 "+num1+"</li>"); // 4

// -- : 대상체의 값을 1씩 감소
num1--; // 후위
--num1; // 전위

document.write("<li>감소연산 후 "+num1+"</li>"); // 2
// 대입 연산자와 함께 사용되거나, 함수의 인수값으로 넣어줄 때에는  
// 전위와 후위가 다른 값을 할당한다.


var result = 0;
// 전위 : 내것 먼저(증가, 감소연산을 먼저 수행하고 할당)
result = ++num1;
document.write("<li>전위연산 후 : result = "+result+", num1 = "+num1+"</li>"); // 3, 3
// 후위 : 남의 것 먼저(할당을 먼저 수행하고 증가나 감소를 나중에 수행)

result = 0;
result = num1++;
document.write("<li>후위연산 후 : result = "+result+", num1 = "+num1+"</li>"); // 3, 4

// 산술연산 : +, -, *, /, %
document.write("<li><strong>산술 연산</strong></li>");
document.write("<li>"+num1%2+"</li>"); // 0

// 쉬프트 연산 : <<, >>, >>>
// << : 비트를 왼쪽으로 밀고 밀어서 생긴 빈칸을 항상 0으로 채운다.
// >> : 비트를 오른쪽으로 밀고 밀어서 생긴 빈칸을 최상위부호비트에 따라 0 또는 1로 채운다.
// >>> : 비트를 오른쪽으로 밀고 밀어서 생긴 빈칸을 항상 0으로 채운다.(unsigned)
document.write("<li><strong>쉬프트 연산</strong></li>");
// 0000 0100 << 2 = 0001 0000
document.write("<li>"+num1+"<<2="+(num1<<2)+"</li>"); // 16

// 0100 >>2 = 0000 0001
document.write("<li>"+num1+">>2="+(num1>>2)+"</li>"); // 1

// 0100 >>>1 = 0000 0010
document.write("<li>"+num1+">>>1="+(num1>>>1)+"</li>"); // 2


// 관계연산 : >, <, >=, <=, ==, ===, !=, !==
num1 = "2";
num2 = 2;
document.write("<li><strong>관계연산</strong></li>");
// == : 데이터형이 달라도 값이 같다면 true
document.write("<li> \"2\" == 2 : "+(num1 == num2)+"</li>"); // true 
// === : 데이터형과 값이 모두 같다면 true
document.write("<li> \"2\" === 2 : "+(num1 === num2)+"</li>"); // false 

// != : 값이 다르면 true
document.write("<li>"+num1+"!="+num2+"="+(num1!=num2)+"</li>"); // false

// !== : 값과 데이터형이 모두 다른지
document.write("<li>"+num1+"!="+num2+"="+(num1!==num2)+"</li>"); // false

// 일반 논리 : &&(전항과 후항이 모두 참일 때 참 반환), 
// 			   ||(전항과 후항이 모두 거짓일 때만 거짓을 반환)
document.write("<li><strong>일반논리 연산</strong></li>");
document.write("<li>"+flag1+"&&"+flag1+"="+(flag1&&flag1)+"</li>"); // false
document.write("<li>"+flag1+"&&"+flag2+"="+(flag1&&flag2)+"</li>"); // false

// 전항이 거짓이면 후항을 연산하지 않는다.
document.write("<li>"+flag1+"||"+flag2+"="+(flag1||flag2)+"</li>"); // false
document.write("<li>"+flag2+"||"+flag2+"="+(flag2||flag2)+"</li>"); // false

// 비트 논리
// & : 상위비트와 하위비트 모두 1인경우 1내림 
// | : 상위비트와 하위비트 모두 0인경우 0내림
// ^ : XOR, 상위비트와 하위비트 둘 중 하나만 1인경우 1내림
num1=21; // 0000 0000 0001 0101  
num2=18; // 0000 0000 0001 0010
		 //         & 0001 0000 - 16
         //         | 0001 0111 - 23
		 //         ^ 0000 0111 - 7

document.write("<li><strong>비트논리 연산</strong></li>");
document.write("<li>"+num1+"&"+num2+"="+(num1&num2)+"</li>");
document.write("<li>"+num1+"|"+num2+"="+(num1|num2)+"</li>");
document.write("<li>"+num1+"^"+num2+"="+(num1^num2)+"</li>");

document.write("<li><strong>삼항 연산</strong></li>");
// 연산식? 항1:항2
document.write("<li>"+num1+"은 "+(num1%num2==0?"짝수":"홀수")+"</li>");

document.write("<li><strong>대입 연산</strong></li>");
// 변수의 값을 변경한다.
// =, +=, -=, *=, /=, %=, <<=, >>=, >>>=, &=, |=, ^=
num1 = 3;
document.write("<li>"+num1+"</li>");

// 산술대입
num1 += 2; // num1 = num1 + 2;
num1 -= 1; // num1 = num1 - 1;
num1 *= 2; // num1 = num1 * 2;
num1 /= 3; // num1 = num1 / 3; // 정수 / 정수 = 실수(Java에선 정수)
document.write("<li>"+num1+"</li>");

num1 = 2;
num1 <<= 4; // num1 = num1 << 4;
document.write("<li>"+num1+"</li>"); // 32

num1 >>= 2;
document.write("<li>"+num1+"</li>"); // 8

num1 >>>= 1; 
document.write("<li>"+num1+"</li>"); // 4

num1 &= 15; // 0000 0100 & 0000 1111 = 0000 0100 
document.write("<li>"+num1+"</li>"); // 4

num1 |= 15; // 0000 0100 | 0000 1111 = 0000 1111
document.write("<li>"+num1+"</li>"); // 15

num1 ^= 15; // 0000 1111 | 0000 1111 = 0000 0000
document.write("<li>"+num1+"</li>"); // 0

num1 = 7;
num2 = 2.7;
flag1 = true;

var msg = "오늘은 목요일입니다. ^o^b";
var msg1 = '내일은 금요일입니다.';

alert(num1+"의 데이터형 "+typeof(num1));
alert(num2+"의 데이터형 "+typeof(num2));
alert(flag1+"의 데이터형 "+typeof(flag1));
alert(msg+"의 데이터형 "+typeof(msg1));
alert(msg1+"의 데이터형 "+typeof(msg1));

window.onload = function() {
	var obj = document.getElementById("id");
	alert(obj+"의 데이터형 "+typeof(obj));
}

// 변수를 선언하지 않고 사용한 경우
alert("변수를 선언하지 않고 사용하면 "+typeof(msg2));
// 수가 아닌 값을 연산하면 NaN
alert("msg1/2"+(msg1/2));



document.write("</ul>");





