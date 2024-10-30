const arr = [10,20,30,40];
let [a, b, c] = arr;
console.log(a, b, c)
/*
let a = arr[0];
let b = arr[1];
let c = arr[2];
*/


const member = {
    id: "hong",
    name: "홍길동",
    age : 22
};

// let memberName = member.name;
let {name: memberName, id, age} = member;
console.log(memberName);
console.log(id);
console.log(age);

/*
let id = member.id;
let name = member.name;
let age = member.age;
*/