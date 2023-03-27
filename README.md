# Capture The Fish

A project created in the course Agile Software Project Management at Chalmers University of Technology.
The aim is to create a game which raises awareness for the UNs sustainability goals in a fun and engaging way.

- Code is located in `capture-the-fish/code`
- Deliverables are located in `capture-the-fish/deliverables`
- Kanban board can be found on [trello](https://trello.com/b/x1DcQ0eq)

## How to install and run

### Installing

1. Clone the repo using `git clone https://github.com/WilliamFrisk/capture-the-fish.git` (or using a GUI, e.g GitHub Desktop)
2. Launch IntelliJ and open the file `build.gradle` in `capture-the-fish/code` using the option **Open as Project**

### Running in IntelliJ

1. Open `capture-the-fish/code` in IntelliJ (This is done automatically if you've just followed the installing instructions)
2. Click the button labeled **gradle** in the upper right side of the window
3. Navigate the gradle hierarchy to `code/desktop/Tasks/other` then press the `run` task

_If you would rather run the code in a local web server follow the same steps but navigate to_
`code/html/Tasks/gwt` _and press the_ `superDev` _task_

### Running in other IDEs

For info on running the code in an IDE or text editor other than IntelliJ check [libGDXs own guide](https://libgdx.com/wiki/start/import-and-running)

## Git Workflow

When implementing a new feature or addressing an issue follow these steps:

### 1. Create a new branch

1. Switch to the `master` branch using `git checkout master` or by selecting it in GitHub Desktop using the
   button labeled **Current Branch**
2. Update the local code using `git pull` or by clicking the **Fetch Origin** button in GitHub Desktop
3. Create a new branch for the changes you intend to make using `git checkout -b <branch-name>` or by clicking **Current Branch** then
   **New Branch** and then entering the name of the branch and selecting the you want to branch from (almost always `master`)
4. You should now automatically be in the new branch but if you want to make sure you can either enter the command `git status` or
   by looking at the **Current Branch** button in GitHub Desktop

### 2. Write code

1. After you've created a new branch or navigated onto to an already created branch you would like to make changes on you can start writing code
2. If you've added or created a new file add them to git using `git add <file-name>`

   **Note:** This step is not necessary if you use GitHub Desktop

3. Commit changes using `git commit -m <message>` or by clicking **Commit to \<branch-name\>** in GitHub Desktop. Give your commits descriptive messages

   **Note:** Make sure to commit your changes regularly, many times in a single coding session (e.g after the implementation of (or part of) a new
   feature).

4. When your done you need to push the code to the remote repo (the shared stuff)
   - If you are using the CLI enter `git push origin <branch-name>`
   - If you are using GitHub Desktop click **Push origin**

### 3. Create a pull request and merge

1. When you want to integrate your changes into the main app you should go to the GitHub website and navigate to **[Pull requests](https://github.com/WilliamFrisk/capture-the-fish/pulls)**
   and click **New pull request**
2. Select which branch you would like to merge in the selector to the right of the arrow (make sure base is master)
3. Click **Create Pull Request**
4. Add title to the pull request and a (high-level) description of the changes you've made
5. Your changes are now ready to be merged into the master branch. If you're unsure whether your code will work or just want another pair of eyes
   you can wait for someone else to review your pull request and ask them to merge it

**Note:** When merging it is possible that merge conflicts arise. This are the most confusing part of git and if you're unsure about how to
resolve these you can ask William

## Authors

- William Frisk - @WilliamFrisk
- Thea Kraft - @theakraft
- Maja Larsson - @larssonmaja23
- Johanna Norell - @jnorelll
- Vendela Palmqvist - @vendelap
- Fanny Sjöström - @fannysj
- Jonathan Svantesson - @MorrisChalmers
- Jacob Westerberg - @Jaegaren

<sub>Last updated 2023-03-27</sub>
