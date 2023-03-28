/*
 * A solution to CodeSignal's SpaceX-inspired "launchSequenceChecker" challenge
 * By A. S. "Aleksey" Ahmann <alexander.ahmann@outlook.com>
 *  - GitHub: https://github.com/Alekseyyy
 *  - Medium: https://medium.com/@EpsilonCalculus
 */

function solution(systemNames, stepNumbers) {
    let nameNumberMap = {};
    for (let k = 0; k < systemNames.length; k++) {
        if (!(systemNames[k] in nameNumberMap))
            nameNumberMap[systemNames[k]] = [stepNumbers[k]];
        else
            nameNumberMap[systemNames[k]].push(stepNumbers[k]);
    }
    for (let k in nameNumberMap) {
        if (nameNumberMap[k] === 1)
            continue;
        else {
            let j = 1;
            while (j < nameNumberMap[k].length) {
                if (nameNumberMap[k][j] <= nameNumberMap[k][j - 1])
                    return false;
                j++;
            }
        }
    }
    return true;
}

