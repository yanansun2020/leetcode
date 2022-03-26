def num_squares(horizontal_lines, vertical_lines):
  hor_points, ver_points = set([point for x1, y1, x2, y2 in horizontal_lines for point in ((x1, y1), (x2, y2))]), set([point for x1, y1, x2, y2 in vertical_lines for point in ((x1, y1), (x2, y2))])
  lines = set([tuple(line) for line in horizontal_lines+vertical_lines])
  inter_points = hor_points & ver_points #相交的点
  xs, ys = sorted(set([x for x, y in inter_points])), sorted(set([y for x, y in inter_points]))
  layers = {y : [] for y in ys}
  for x, y in inter_points:
    layers[y].append(x)
  num = 0
  x_pairs = {}
  for y in ys:
    cur_layer = layers[y]
    for i in range(len(cur_layer)):
      x1 = cur_layer[i]
      for j in range(i+1, len(cur_layer)):
        x2 = cur_layer[j]
        x_pair, x_dis = (min(x1, x2), max(x1, x2)), abs(x1-x2)
        target_y = y-x_dis
        if x_pair in x_pairs and target_y in x_pairs[x_pair]:
          #需要判断每一条边都存在
          add_square = 1
          for tmp_x in (x1, x2):
            if not add_square:
              break
            for mid_y in range(target_y, y):
              tmp_ver_line = (tmp_x, mid_y, tmp_x, mid_y+1)
              if tmp_ver_line not in lines:
                add_square = 0
                break

          for tmp_y in (y, target_y):
            if not add_square:
              break
            for mid_x in range(min(x1, x2), max(x1, x2)):
              tmp_hor_line = (mid_x, tmp_y, mid_x+1, tmp_y)
              if tmp_ver_line not in lines:
                add_square = 0
                break
          num += add_square
        if x_pair not in x_pairs:
          x_pairs[x_pair] = set()
        x_pairs[x_pair].add(y)
  return num

horizontal_lines = [[0,0,0,1], [0,1,0,2], [0,2,0,3], [0,3,0,4], [2,0,2,1], [2, 1, 2, 2], [1, 2, 1, 3], [1,3,1,4], [3,2,3,3], [3,3,3,4], [4,0,4,1], [4,1,4,2], [4,2,4,3], [4,3, 4, 4]]
vertical_lines = [[0, 0, 1, 0], [1,0,2,0], [2,0,3,0], [3,0,4,0], [0,2,1,2], [1, 2, 2,2],[2, 2,3,2],[3, 2,4,2], [0,4,1,4] , [1,4,2,4] , [2,4,3,4] , [3,4,4,4] ]
print(num_squares(horizontal_lines, vertical_lines))
