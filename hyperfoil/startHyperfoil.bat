@echo off
docker run ^
    --rm ^
    -v "C:\Users\Daniel\OneDrive\#D@niel#\#_HEG\Semestre_6\24_25_TechnologiesEmergentes\Projet\myfirstappquarkus\hyperfoil:/benchmarks" ^
    -v "C:\Users\Daniel\OneDrive\#D@niel#\#_HEG\Semestre_6\24_25_TechnologiesEmergentes\Projet\myfirstappquarkus\hyperfoil\reports:/tmp/reports" ^
    quay.io/hyperfoil/hyperfoil ^
    run -o /tmp/reports /benchmarks/helloBenchmark.yml
