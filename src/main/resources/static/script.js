function runScan() {

    const target = document.getElementById("target").value;

    fetch("http://localhost:8080/scan/" + target)
        .then(response => response.json())
        .then(data => {

            document.getElementById("result").textContent =
                "Target: " + data.target + "\n\n" +
                "Threat Level: " + data.threatLevel + "\n" +
                "Risk Score: " + data.riskScore + "\n\n" +
                "Scan Output:\n" + data.openPorts;
        });
}