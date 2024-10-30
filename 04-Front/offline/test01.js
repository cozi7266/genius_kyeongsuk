function fn1(msg){         // 선언문
    console.log("fn1");    
}

const fn2 = function(){    // 표현식
    console.log("fn2");
};

const fn3 = () => {         // 화살표 함수                                  
    console.log("fn3");     
}

fn1();
fn2();
fn3();