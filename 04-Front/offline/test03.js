function fn1(num) {
    return num * num;
}

const fn1_a = (num) => {
    return num*num
};

// 실행문장이 한 문장일 경우 블럭을 생략할 수 있다.
// 만약, 실행문장이 return을 포함한다면 return 생략해야 한다.
const fn1_a2 = (num) => num * num;

// 실행문장이 2문장 이상일 경우에는 블럭의 생략이 불가능 하다.
const fn1_a3 = (num) => {
    console.log(num);
    return num*num;
};