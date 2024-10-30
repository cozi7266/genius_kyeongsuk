function getMemberInfo() {
    return {
        id: "hong",
        age: 22,
        nickName: "홍길동"
    };
}
let {id, age, nickName} = getMemberInfo();
console.log(id, age , nickName);