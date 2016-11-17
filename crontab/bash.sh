export LC_ALL=C

ip=$(ifconfig | grep -oE "\b([0-9]{1,3}\.){3}[0-9]{1,3}\b" | grep -v '.255' | grep -v '255.' | grep -v '0.0.0.0'  | grep -v '127.0.0.1' | grep -v '172.' | grep -v '192.')
totalMemory=$(vmstat -s | grep 'total memory' | sed 's/total memory//' | sed 's/K//' )
usedMemory=$(vmstat -s | grep 'used memory' | sed 's/used memory//' | sed 's/K//')
activeMemory=$(vmstat -s | grep -w 'active memory' | sed 's/active memory//' | sed 's/K//')
inactiveMemory=$(vmstat -s | grep -w 'inactive memory' | sed 's/inactive memory//' | sed 's/K//' )
freeMemory=$(vmstat -s | grep 'free memory' | sed 's/free memory//' | sed 's/K//')
bufferMemory=$(vmstat -s | grep 'buffer memory' | sed 's/buffer memory//' | sed 's/K//')
swapCache=$(vmstat -s | grep 'swap cache' | sed 's/swap cache//' | sed 's/K//')
totalSwap=$(vmstat -s | grep 'total swap' | sed 's/total swap//' | sed 's/K//')
usedSwap=$(vmstat -s | grep 'used swap' | sed 's/used swap//' | sed 's/K//')
freeSwap=$(vmstat -s | grep 'free swap' | sed 's/free swap//' | sed 's/K//')
nonNiceUserCpuTicks=$(vmstat -s | grep 'non-nice user cpu ticks' | sed 's/non-nice//'  | sed 's/user//' | sed 's/cpu//' | sed 's/ticks//')
niceUserCpuTicks=$(vmstat -s | grep 'nice user cpu ticks' | grep -v 'non' | sed 's/nice//'  | sed 's/user//' | sed 's/cpu//' | sed 's/ticks//')
systemCpuTicks=$(vmstat -s | grep 'system cpu ticks' | sed 's/system cpu ticks//')
idleCpuTicks=$(vmstat -s | grep 'idle cpu ticks' | sed 's/idle cpu ticks//')
ioWaitCpuTicks=$(vmstat -s | grep 'IO-wait cpu ticks' | sed 's/IO-wait cpu ticks//')
irqCpuTicks=$(vmstat -s | grep 'IRQ cpu ticks' | sed 's/IRQ cpu ticks//')
softirqCpuTicks=$(vmstat -s | grep 'softirq cpu ticks' | sed 's/softirq cpu ticks//')
stolenCpuTicks=$(vmstat -s | grep 'stolen cpu ticks' | sed 's/stolen cpu ticks//')
pagesPagedIn=$(vmstat -s | grep 'pages paged in' | sed 's/pages paged in//')
pagesPagedOut=$(vmstat -s | grep 'pages paged out' | sed 's/pages paged out//')
pagesSwappedIn=$(vmstat -s | grep 'pages swapped in' | sed 's/pages swapped in//')
pagesSwappedOut=$(vmstat -s | grep 'pages swapped out' | sed 's/pages swapped out//')
interrupts=$(vmstat -s | grep 'interrupts' | sed 's/interrupts//')
cpuContextSwitches=$(vmstat -s | grep 'CPU context switches' | sed 's/CPU context switches//')
bootTime=$(vmstat -s | grep 'boot time' | sed 's/boot time//')
forks=$(vmstat -s | grep 'forks' | sed 's/forks//')

echo 'ip =' $ip
echo 'totalMemory =' $totalMemory
echo 'usedMemory =' $usedMemory
echo 'activeMemory =' $activeMemory
echo 'inactiveMemory =' $inactiveMemory
echo 'freeMemory =' $freeMemory
echo 'bufferMemory =' $bufferMemory
echo 'swapCache = ' $swapCache
echo 'totalSwap = ' $totalSwap
echo 'usedSwap = ' $usedSwap
echo 'freeSwap = ' $freeSwap
echo 'nonNiceUserCpuTicks = ' $nonNiceUserCpuTicks
echo 'niceUserCpuTicks = ' $niceUserCpuTicks
echo 'systemCpuTicks = ' $systemCpuTicks
echo 'idleCpuTicks = ' $idleCpuTicks
echo 'ioWaitCpuTicks = ' $ioWaitCpuTicks
echo 'irqCpuTicks = ' $irqCpuTicks
echo 'softirqCpuTicks = ' $softirqCpuTicks
echo 'stolenCpuTicks = ' $stolenCpuTicks
echo 'pagesPagedIn = ' $pagesPagedIn
echo 'pagesPagedOut = ' $pagesPagedOut
echo 'pagesSwappedIn = ' $pagesSwappedIn
echo 'pagesSwappedOut = ' $pagesSwappedOut
echo 'interrupts = ' $interrupts
echo 'cpuContextSwitches = ' $cpuContextSwitches
echo 'bootTime = '$bootTime
echo 'forks = '$forks

URL=http://localhost:8081/audit/?ipRunnerMachine=$ip\&totalMemory=$totalMemory\&usedMemory=$usedMemory\&activeMemory=$activeMemory\&inactiveMemory=$inactiveMemory\&freeMemory=$freeMemory\&bufferMemory=$bufferMemory\&swapCache=$swapCache\&totalSwap=$totalSwap\&usedSwap=$usedSwap\&freeSwap=$freeSwap\&nonNiceUserCpuTicks=$nonNiceUserCpuTicks\&niceUserCpuTicks=$niceUserCpuTicks\&systemCpuTicks=$systemCpuTicks\&idleCpuTicks=$idleCpuTicks\&ioWaitCpuTicks=$ioWaitCpuTicks\&irqCpuTicks=$irqCpuTicks\&softirqCpuTicks=$softirqCpuTicks\&stolenCpuTicks=$stolenCpuTicks\&pagesPagedIn=$pagesPagedIn\&pagesPagedOut=$pagesPagedOut\&pagesSwappedIn=$pagesSwappedIn\&pagesSwappedOut=$pagesSwappedOut\&interrupts=$interrupts\&cpuContextSwitches=$cpuContextSwitches\&bootTime=$bootTime\&forks=$forks
URL=$(echo $URL | sed 's/ //g')
echo $URL

curl -X PUT $URL
