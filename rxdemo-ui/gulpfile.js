let gulp = require('gulp');
let del = require('del');
let zip = require('gulp-zip');

gulp.task('clean-dist', function () {
  return del([
    'dist/'
  ]);
});

gulp.task("copy", function() {
  return gulp.src(['index.html', 'images/**', 'scripts/**', 'config/**', 'styles/**'], {base: "."})
    .pipe(gulp.dest('dist/'));
});

gulp.task("archive", function() {
  return gulp.src(['dist/**'], {base: "."})
    .pipe(zip('dist.zip'))
    .pipe(gulp.dest('.'));
});

gulp.task("dist", gulp.series(['clean-dist', 'copy', 'archive']));

