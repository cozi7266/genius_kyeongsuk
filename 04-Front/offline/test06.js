const arr = [1, 10, 100];
console.log(...arr);

const arr2 = [2, 20, 200, ...arr];
console.log(arr2);

const obj1 = {id: "hong", age: 22, email: "kim@kim.com"};
const obj2 = {email: "hong@hong.com",... obj1};
console.log(obj2);
const obj3 = {... obj1, email: "hong@hong.com"};
console.log(obj3);

/*
for(let i = 0; i < arr.length; i++) {
    arr2[i] = arr[i];
}
*/


function fn(a, b, c){
    console.log(a, b, c);
}
const a =[100, 200, 300];
// fn(a[0], a[1], a[2]);
fn(...a);