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
var maxFibCalculated = 0;
var F = [0, 1];
function fib(n) {
	// nth elem of fib
	if (n <= F.length - 1) {
		return F[n];
	}
	return (fib(n) + fib(n-1));
}
function findHighestFibIndex(n) {
	if(F[F.length -1] <= n) return F.length-1;
	var l=0, h=F.length-1;
	while(true) {
		if(F[h] <= n) return h;
		if(h=l+1) {
			if(F[l]<=n) return l;
		}
		var mid = parseInt(h/2);
		if(F[l] == n) return l;
		if(F[mid] == n) return mid;
		if(F[mid+1] == n) return mid+1;
		if(F[h] == n) return h;
		if(F[l] < n && n < F[mid]) h=mid;
		if(F[mid+1] < n && n < F[h]) l = mid+1;

	}
}
function init() {
	for (var i = 2; i <= 100; i++) {
		F[i] = fib(i);
	}
	maxFibCalculated = F[100];
}
var ANS = {

};
function add(a, b) {
	return parseInt(a) + parseInt(b);
}
function isEven(str) {
	return parseInt(str.indexOf(str.length - 1)) % 2;
}
function main() {
    var t = parseInt(readLine());
    for(var a0 = 0; a0 < t; a0++){
        var n = parseInt(readLine());

    }

}
