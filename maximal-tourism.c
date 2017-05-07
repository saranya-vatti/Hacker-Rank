//https://www.hackerrank.com/contests/rookierank-3/challenges/maximal-tourism/submissions/code/1301563975
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
var graph, marked, n, ans, conn_num;
function bfs(v) {
    var qu = [];
    qu.push(v);
    while(qu.length > 0) {
        vertex = qu.shift();
        if(marked[vertex] != 1) {
            marked[vertex] = 1;
            conn_num++;
            for (var i=0;i<graph[vertex].length;i++) {
                var next = graph[vertex][i];
                if (marked[next] == 0 && qu.indexOf(next) == -1) {
                    qu.push(next);
                }
            }
        }
    }
}
function main() {
    var n_temp = readLine().split(' ');
    n = parseInt(n_temp[0]);
    var m = parseInt(n_temp[1]);
    var route = [];
    conn_num = 0, ans = 0;
    graph = new Array(n);
    marked = new Array(n);
    for(var i = 0; i < n; i++) {
        marked[i] = 0;
        graph[i] = [];
    }
    for(route_i = 0; route_i < m; route_i++){
       route[route_i] = readLine().split(' ');
       route[route_i] = route[route_i].map(Number);
       var v = route[route_i][0] - 1;
       var w = route[route_i][1] - 1;
       if (graph[v].indexOf(w) == -1 && v != w) graph[v].push(w);
       if (graph[w].indexOf(v) == -1 && v != w) graph[w].push(v);
    }
    for (var i = 0; i < marked.length; i++) {
        if(marked[i]==0) {
            conn_num = 0;
            bfs(i);
            ans = conn_num>ans ? conn_num : ans;
        }
    }
    console.log(ans);
}
