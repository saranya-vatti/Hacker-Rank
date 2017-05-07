//https://www.hackerrank.com/contests/rookierank-3/challenges/culture-conference/submissions/code/1301575869
process.stdin.resume();
process.stdin.setEncoding('ascii');

var input_stdin = "";
var input_stdin_array = "";
var input_currentline = 0;

process.stdin.on('data', function (data) {
    input_stdin += data;
});

process.stdin.on('end', function () {
    input_stdin_array = input_stdin.split("\n");
    main();    
});

function readLine() {
    return input_stdin_array[input_currentline++];
}

/////////////// ignore above this line ////////////////////
var vacation = {}, checked={}, children=[],burned=[], parent=[], n;
function DFS(emp) {
    var quIn=[emp];
    var quOut=[];
    while(quIn.length>0) {
        var tmp = quIn.pop();
        quOut.push(tmp);
        quIn.concat(children[tmp]);
    }
    while(quOut.length>0) {
        emp = quOut.pop();
        if(burned[emp] == 1) return;
        var isGoing = ~~vacation[emp];
        var isParentGoing = ~~vacation[parent[emp]];
        var isChildGoing = false;
        for (var i = 0; i < children[emp].length; i++) {
            if(vacation[children[emp][i]]) {
                isChildGoing = true;
                break;
            }
        }
        if(!isGoing && !isChildGoing && !isParentGoing) {
            vacation[parent[emp]]=1;
        }
    }
    
}
function getMinimumEmployees(e){
    // Complete this function
    burned[0]=1;
    for (var i = 0; i < n; i++) {
        children[i] = [];
        burned[i]=1;
    }
    for (var i = 1; i <= e.length; i++) {
        var p = i;
        var q = e[i-1][0];
        children[q].push(p);
        parent[p] = q;
        burned[i] = e[i-1][1]; // 0 is burned, 1 is not
    }
    for (var i = children.length-1; i >=0 ; i--) {
        checked = {};
        DFS(i);
    }
    return Object.keys(vacation).length;
}
function main() {
    n = parseInt(readLine());
    // Information for employees 1 through n - 1:
    // The first value is the employee's supervisor ID
    // The second value is the employee's burnout status (0 is burned out, 1 is not)
    var e = [];
    for(e_i = 0; e_i < n-1; e_i++){
       e[e_i] = readLine().split(' ');
       e[e_i] = e[e_i].map(Number);
    }
    var minimumEmployees = getMinimumEmployees(e);
    process.stdout.write(""+minimumEmployees+"\n");
}
