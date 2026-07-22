%
% zyBooks practice problems 
% 2.8 MATLAB: Solve Systems of Linear Equations Revisited
%
% By Alexander Ahmann <alexander.ahmann@snhu.edu>
%   - GitHub: https://github.com/Alekseyyy
%

%Create the coefficient matrix.  Store the coefficient matrix in A.

A = [-2 1 2;
    1 3 2;
    3 -1 1]

%Create the column matrix of constants.  Store the column matrix of constants in b.

b = [0; -4; 3]

%Use the inv() command to find the inverse of the matrix A.  Store the inverse matrix in invA.

invA = inv(A)

%Find the solution to the linear system of equations using the inverse matrix, if the inverse matrix
%exists.  If the inverse matrix exists, store the solution to the linear system of equations in x.

x = invA * b

%Before submitting your solution, consider repeating the work above with the coefficient matrix A = [-2 1 2; 1 3 2; -1 4 4].  Do you run into any difficulties or errors when finding the solution?  Explain what is happening as a comment in your code.

%A_2 = [-2 1 2; 1 3 2; -1 4 4]
%b_2 = [0; -4; 3]
%invA_2 = inv(A_2)
%x_2 = invA_2 * b_2

%
% So, the *_2 is an attempt to solve a system of linear equations with
%   a different coefficient matrix, but I got a lot of warnings with 
%   these values. The following is the warning log:
%
%   [Warning: Matrix is singular to working precision.] 
%   [> In solution (line 24)
%   In run (line 100)
%   In scoringengine.runScript
%   In ScoringEngineSharedVariable1 (line 1)
%   In solutionTest (line 3)
%   In matlab.unittest.internal.executeScriptLines (line 12)
%   In matlab.unittest.internal/ScriptTestCaseProvider/evaluateTestSection (line 123)
%   In matlab.unittest.internal/ScriptTestCaseProvider/runTestSection (line 117)
%   In @(testCase)provider.runTestSection(testCase)', '/MATLAB/toolbox/matlab/testframework/unittest/ext/+matlab/+unittest/+internal/ScriptTestCaseProvider.m', 96)" style="font-weight:bold">matlab.unittest.internal.ScriptTestCaseProvider>@(testCase)provider.runTestSection(testCase) (line 96)
%   In matlab.unittest/TestRunner/evaluateMethodCore (line 864)
%   In matlab.unittest/TestRunner/evaluateMethod (line 1326)
%   In matlab.unittest.plugins/TestRunnerPlugin/evaluateMethod (line 139)
%   In scoringengine/OutputPlugin/evaluateMethod
%   In matlab.unittest.plugins/TestRunnerPlugin/evaluateMethod (line 139)
%   In scoringengine/FiguresPlugin/evaluateMethod
%   In matlab.unittest/TestRunner/evaluateMethodsOnTestContent (line 794)
%   In matlab.unittest/TestRunner/runTestMethodCore (line 980)
%   In matlab.unittest/TestRunner/runTestMethod (line 1320)
%   In matlab.unittest.plugins/TestRunnerPlugin/runTestMethod (line 122)
%   In scoringengine/OutputPlugin/runTestMethod
%   In matlab.unittest.plugins/TestRunnerPlugin/runTestMethod (line 122)
%   In scoringengine/FiguresPlugin/runTestMethod
%   In matlab.unittest/TestRunner/runTestCore (line 945)
%   In matlab.unittest/TestRunner/repeatTest (line 396)] 
%   [In matlab.unittest/TestRunner/runSharedTestCase (line 337)
%   In matlab.unittest/TestRunner/runTestClass (line 1252)
%   In matlab.unittest/TestRunner/runTestSuite (line 1176)
%   In matlab.unittest.plugins/TestRunnerPlugin/runTestSuite (line 38)
%   In scoringengine/OutputPlugin/runTestSuite
%   In matlab.unittest.plugins/TestRunnerPlugin/runTestSuite (line 38)
%   In scoringengine/FiguresPlugin/runTestSuite
%   In matlab.unittest.plugins/TestRunnerPlugin/runTestSuite (line 38)
%   In matlab.unittest.plugins/DiagnosticsRecordingPlugin/runTestSuite (line 79)
%   In matlab.unittest/TestRunner/evaluateMethodOnPlugins (line 254)
%   In matlab.unittest.internal/SerialTestRunStrategy/runTestSuite (line 36)
%   In matlab.unittest.internal/SerialTestRunStrategy/runSession (line 16)
%   In matlab.unittest/TestRunner/runSession (line 1133)
%   In matlab.unittest/TestRunner/evaluateMethodOnPlugins (line 254)
%   In matlab.unittest/TestRunner/doRunWithFcn (line 242)
%   In matlab.unittest/TestRunner/run (line 138)
%   In scoringengine.verifyCode
%   In scoringengine.verifyCode
%   In connector.internal.fevalMatlab
%   In connector.internal.fevalJSON
%
% The result is "inf", or infintiy, for the inverse matrix, and
% "nan", or a null value, for the b-vector. I presume that this 
% implies that the system is inconsistent, or has infinitely many
% solutions. 
%

