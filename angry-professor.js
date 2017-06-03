var n = 4;
var k = 2;
var a = "-1 -3 4 2".split(" ");
var present = 0;
for(var i=0;i<n;i++) {
	if(a[i]<=0) present++;
}
if(present<k) console.log("YES");
else console.log("NO");