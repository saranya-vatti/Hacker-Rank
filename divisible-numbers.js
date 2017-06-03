process.stdin.resume();
process.stdin.setEncoding("ascii");
var _input = "";
process.stdin.on("data", function (input) {
    _input += input;
});

process.stdin.on("end", function () {
   processData(_input);
});

function sumProd(num) {
	num=num+"";
	var sum = 0;
	var prod = 1;
	for (var i = 0; i < num.length; i++) {
		sum += parseInt(num[i]);
		prod = prod * parseInt(num[i]);
	}
	return {
		"sum": sum,
		"prod": prod
	};
}
function processData(n) {
    console.log(n);
    /*for(var i=0;i<n;i++) {
        if ((i+"").indexOf("0") == -1 && sumProd(i).sum >= sumProd(i).prod && n%i == 0) {
            return (i+"").length;
            break;
        }
    }*/
} 
